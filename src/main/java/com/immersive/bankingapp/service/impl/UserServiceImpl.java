package com.immersive.bankingapp.service.impl;

import com.immersive.bankingapp.dao.UserDAO;
import com.immersive.bankingapp.dto.UserDTO;
import com.immersive.bankingapp.model.User;
import com.immersive.bankingapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User save(User newUser) {
        UserDTO userDTO = new UserDTO(newUser);
        if (userDTO.getUserId() == 0) userDTO.setStatus(1);
        return new User(this.userDAO.save(userDTO));
    }

    @Override
    public List<User> findAllUsers() {
        List<UserDTO> userDTOs = userDAO.findAll();
        List<User> users = userDTOs.stream().map(User::new).collect(Collectors.toList());
        return users;
    }

    @Override
    public User findUserById(int userId) {
        UserDTO userDTO = userDAO.findByUserId(userId);
        User user = new User(userDTO);
        return user;
    }

    @Override
    public User findUserByEmailAndPassword(User user) {
        UserDTO userDTO = userDAO.findByEmailAndPassword(user.getEmail(), user.getPassword());
        user = new User(userDTO);
        return user;
    }
}
