package com.immersive.bankingapp.dao;

import com.immersive.bankingapp.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserDTO, Integer> {
    UserDTO findByUserId(int userId);
    UserDTO findByEmailAndPassword(String email, String password);
}
