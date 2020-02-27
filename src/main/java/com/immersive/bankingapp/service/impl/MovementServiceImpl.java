package com.immersive.bankingapp.service.impl;

import com.immersive.bankingapp.dao.AccountDAO;
import com.immersive.bankingapp.dao.MovementDAO;
import com.immersive.bankingapp.dto.AccountDTO;
import com.immersive.bankingapp.dto.MovementDTO;
import com.immersive.bankingapp.model.Movement;
import com.immersive.bankingapp.service.MovementService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementServiceImpl implements MovementService {

    private MovementDAO movementDAO;
    private AccountDAO accountDAO;

    public MovementServiceImpl(MovementDAO movementDAO, AccountDAO accountDAO) {
        this.movementDAO = movementDAO;
        this.accountDAO = accountDAO;
    }

    @Override
    public Movement save(Movement movement) {
        MovementDTO movementDTO = new MovementDTO(movement);
        float amount = movementDTO.getAmount();
        if (movementDTO.getMovementId() == 0) {
            movementDTO.setDateTime(LocalDateTime.now());
            movementDTO.setStatus(1);
        }

        if (!movementDTO.getOriginAccount().getCurrency().equals(movement.getDestinationAccount().getCurrency())) {
            switch (movementDTO.getDestinationAccount().getCurrency()) {
                case "CRC":
                    amount = movementDTO.getAmount() * movementDTO.getConversionFee();
                    break;
                case "USD":
                    amount = movementDTO.getAmount() / movementDTO.getConversionFee();
                    break;
                default:
                    break;
            }
        }

        movementDTO.getDestinationAccount().setBalance(movementDTO.getDestinationAccount().getBalance() + amount);
        movementDTO.getOriginAccount().setBalance(movementDTO.getOriginAccount().getBalance() - movementDTO.getAmount());

        accountDAO.save(movementDTO.getOriginAccount());
        accountDAO.save(movementDTO.getDestinationAccount());
        return new Movement(this.movementDAO.save(movementDTO));
    }

    @Override
    public List<Movement> findAllMovementsByAccount(int accountId) {
        List<MovementDTO> movementDTOList = movementDAO.findAllByOriginAccount_AccountIdOrDestinationAccount_AccountId(accountId, accountId);
        List<Movement> movementList = movementDTOList.stream().map(Movement::new).collect(Collectors.toList());
        return movementList;
    }

    @Override
    public List<List<List<Movement>>> findAllWeeklyMovementsByUser(int userId) {
        List<AccountDTO> accounts = accountDAO.findAllByOwner_UserId(userId);
        List<List<List<Movement>>> movements = new ArrayList<>();
        for (AccountDTO accountDTO: accounts){
            movements.add(findAllMovementsOfWeek(accountDTO.getAccountId()));
        }
        return movements;
    }

    private List<List<Movement>> findAllMovementsOfWeek(int accountId) {
        List<List<Movement>> weekTransactions = new ArrayList<>();
        List<MovementDTO> dailyTransactionsDTO;
        List<MovementDTO> accountTransactionsDTO;
        accountTransactionsDTO = this.movementDAO.findAllByOriginAccount_AccountIdOrDestinationAccount_AccountId(accountId, accountId);
        for (int i = 0; i < 7; i++) {
            dailyTransactionsDTO = movementDAO.findAllByDateTimeBetween(
                    LocalDateTime.now()
                            .withHour(0)
                            .withDayOfMonth(LocalDateTime.now().getDayOfMonth() - 6 + i),
                    LocalDateTime.now()
                            .withDayOfMonth(LocalDateTime.now().getDayOfMonth() - 6 + i)
                            .withHour(23));
            dailyTransactionsDTO.retainAll(accountTransactionsDTO);
            weekTransactions.add(dailyTransactionsDTO.stream().map(Movement::new).collect(Collectors.toList()));
        }
        return weekTransactions;
    }
}
