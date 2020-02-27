package com.immersive.bankingapp.service;

import com.immersive.bankingapp.model.Account;
import com.immersive.bankingapp.model.Movement;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementService {
    public Movement save(Movement movement);
    public List<Movement> findAllMovementsByAccount(int accountId);
    public List<List<List<Movement>>> findAllWeeklyMovementsByUser(int userId);
}
