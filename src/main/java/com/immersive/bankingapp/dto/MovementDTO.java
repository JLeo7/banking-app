package com.immersive.bankingapp.dto;

import com.immersive.bankingapp.model.Movement;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movements")
public class MovementDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movementId;

    private String detail;

    private float amount;

    private LocalDateTime dateTime;

    private float conversionFee;

    private int status;

    @ManyToOne
    @JoinColumn(name = "origin_account")
    private AccountDTO originAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account")
    private AccountDTO destinationAccount;

    public MovementDTO() {
    }

    public MovementDTO(Movement movement) {
        this.movementId = movement.getMovementId();
        this.detail = movement.getDetail();
        this.amount = movement.getAmount();
        this.dateTime = movement.getDateTime();
        this.conversionFee = movement.getConversionFee();
        this.status = movement.getStatus();
        this.originAccount = new AccountDTO(movement.getOriginAccount());
        this.destinationAccount = new AccountDTO(movement.getDestinationAccount());
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

    public AccountDTO getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(AccountDTO originAccount) {
        this.originAccount = originAccount;
    }

    public AccountDTO getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(AccountDTO destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
