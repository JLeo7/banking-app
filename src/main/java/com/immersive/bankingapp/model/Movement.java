package com.immersive.bankingapp.model;

import java.time.LocalDateTime;

public class Movement {
    private int movementId;
    private String detail;
    private float amount;
    private LocalDateTime dateTime;
    private float conversionFee;
    private Account originAccount;
    private Account destinationAccount;
}
