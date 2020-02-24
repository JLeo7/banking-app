package com.immersive.bankingapp.model;

import com.immersive.bankingapp.dto.AccountDTO;

import java.time.LocalDate;

public class Account {
    private int accountId;
    private float balance;
    private String name;
    private int status;
    private String currency;
    private LocalDate creationDate;
    private int number;
    private int type;
    private LocalDate endDate;
    private User owner;

    public Account() {
    }

    public Account(AccountDTO account) {
        this.accountId = account.getAccountId();
        this.balance = account.getBalance();
        this.name = account.getName();
        this.status = account.getStatus();
        this.currency = account.getCurrency();
        this.creationDate = account.getCreationDate();
        this.number = account.getNumber();
        this.type = account.getType();
        this.endDate = account.getEndDate();
        this.owner = new User(account.getOwner());
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
