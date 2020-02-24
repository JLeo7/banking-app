package com.immersive.bankingapp.dto;

import com.immersive.bankingapp.model.Account;

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

    @ManyToOne
    @JoinColumn(name = "origin_account")
    private AccountDTO originAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account")
    private AccountDTO destinationAccount;
}
