package com.immersive.bankingapp.service.impl;

import com.immersive.bankingapp.dao.AccountDAO;
import com.immersive.bankingapp.dto.AccountDTO;
import com.immersive.bankingapp.model.Account;
import com.immersive.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account save(Account account) {
        AccountDTO accountDTO = new AccountDTO(account);
        if (accountDTO.getAccountId() == 0) {
            accountDTO.setStatus(1);
            accountDTO.setBalance(0);
            accountDTO.setNumber(1130209000 + (int) this.accountDAO.count());
            accountDTO.setCreationDate(LocalDate.now());
            if (accountDTO.getName().equals("")) accountDTO.setName(accountDTO.getNumber()+"");
        };
        return new Account(this.accountDAO.save(accountDTO));
    }

    @Override
    public List<Account> findAllAccountsByUserId(int userId) {
        List<AccountDTO> accountDTOList = accountDAO.findAllByOwner_UserId(userId);
        List<Account> accounts = accountDTOList.stream().map(Account::new).collect(Collectors.toList());
        return accounts;
    }

    @Override
    public Account findByAccountNumber(int number) {
        AccountDTO accountDTO = accountDAO.findByNumber(number);
        Account account = new Account(accountDTO);
        return account;
    }

    @Override
    public Account findByAccountId(int accountId) {
        AccountDTO accountDTO = accountDAO.findByAccountId(accountId);
        Account account = new Account(accountDTO);
        return account;
    }
}
