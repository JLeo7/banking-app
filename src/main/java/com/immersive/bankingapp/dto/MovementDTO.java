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

//    private AccountDTO originAccount;
//
//    private AccountDTO destinationAccount;
}
