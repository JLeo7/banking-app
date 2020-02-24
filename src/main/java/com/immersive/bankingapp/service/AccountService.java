package com.immersive.bankingapp.service;

import com.immersive.bankingapp.model.Account;

import java.util.List;

public interface AccountService {
    public Account save(Account account);
    public List<Account> findAllAccountsByUserId(int userId);
    public Account findByAccountNumber(int number);
    public Account findByAccountId(int accountId);
}
