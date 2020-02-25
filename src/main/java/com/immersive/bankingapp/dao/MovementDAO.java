package com.immersive.bankingapp.dao;

import com.immersive.bankingapp.dto.AccountDTO;
import com.immersive.bankingapp.dto.MovementDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementDAO extends JpaRepository<MovementDTO, Integer> {
    List<MovementDTO> findAllByOriginAccount_AccountIdOrDestinationAccount_AccountId(int originAccountId, int destinationAccountId);
}
