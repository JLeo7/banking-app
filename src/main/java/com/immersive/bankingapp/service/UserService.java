package com.immersive.bankingapp.service;

import com.immersive.bankingapp.model.User;

import java.util.List;

public interface UserService {
    public User save(User newUser);
    public List<User> findAllUsers();
    public User findUserById(int userId);
    public User findUserByEmailAndPassword(User user);
}
