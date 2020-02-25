package com.immersive.bankingapp.model;

import com.immersive.bankingapp.dto.AccountDTO;
import com.immersive.bankingapp.dto.MovementDTO;

import java.time.LocalDateTime;

public class Movement {
    private int movementId;
    private String detail;
    private float amount;
    private LocalDateTime dateTime;
    private float conversionFee;
    private int status;
    private Account originAccount;
    private Account destinationAccount;

    public Movement() {
    }

    public Movement(MovementDTO movement) {
        this.movementId = movement.getMovementId();
        this.detail = movement.getDetail();
        this.amount = movement.getAmount();
        this.dateTime = movement.getDateTime();
        this.conversionFee = movement.getConversionFee();
        this.status = movement.getStatus();
        this.originAccount = new Account(movement.getOriginAccount());
        this.destinationAccount = new Account(movement.getDestinationAccount());
    }

    public int getMovementId() {
        return movementId;
    }

    public void setMovementId(int movementId) {
        this.movementId = movementId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public float getConversionFee() {
        return conversionFee;
    }

    public void setConversionFee(float conversionFee) {
        this.conversionFee = conversionFee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Account originAccount) {
        this.originAccount = originAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
