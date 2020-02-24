package com.immersive.bankingapp.dao;

import com.immersive.bankingapp.dto.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDAO extends JpaRepository<AccountDTO, Integer> {
    List<AccountDTO> findAllByOwner_UserId(int userId);
    AccountDTO findByNumber(int number);
    AccountDTO findByAccountId(int accountId);
}
