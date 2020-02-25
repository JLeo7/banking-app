package com.immersive.bankingapp.service.impl;

import com.immersive.bankingapp.dao.AccountDAO;
import com.immersive.bankingapp.dao.MovementDAO;
import com.immersive.bankingapp.dto.MovementDTO;
import com.immersive.bankingapp.model.Movement;
import com.immersive.bankingapp.service.MovementService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        if (movementDTO.getMovementId() == 0) {
            movementDTO.setDateTime(LocalDateTime.now());
            movementDTO.setStatus(1);
        }
        movementDTO.getOriginAccount().setBalance(movementDTO.getOriginAccount().getBalance() - movementDTO.getAmount());
        movementDTO.getDestinationAccount().setBalance(movementDTO.getDestinationAccount().getBalance() + movementDTO.getAmount());
        accountDAO.save(movementDTO.getOriginAccount());
        accountDAO.save(movementDTO.getDestinationAccount());
        return new Movement(this.movementDAO.save(movementDTO));
    }

    @Override
    public List<Movement> findAllMovementsByAccount(int accountId) {
        List<MovementDTO> movementDTOList = movementDAO.findAllByOriginAccount_AccountIdOrDestinationAccount_AccountId(accountId,accountId);
        List<Movement> movementList = movementDTOList.stream().map(Movement::new).collect(Collectors.toList());
        return movementList;
    }
}
