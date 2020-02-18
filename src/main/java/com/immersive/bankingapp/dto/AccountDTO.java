package com.immersive.bankingapp.dto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class AccountDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    private float balance;

    private String name;

    private int status;

    private String currency;

    private LocalDate creationDate;

    private int number;

    private int type;

    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDTO owner;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private CardDTO card;

//    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
//    private List<MovementDTO> movements;

}
