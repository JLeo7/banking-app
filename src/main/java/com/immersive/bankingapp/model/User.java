package com.immersive.bankingapp.model;

import com.immersive.bankingapp.dto.UserDTO;

import java.time.LocalDate;

public class User {
    private int userId;
    private String name;
    private String lastName;
    private String idNumber;
    private String idFrontImageUrl;
    private String idBackImageUrl;
    private String firstAddress;
    private String secondAddress;
    private int postalCode;
    private LocalDate birthDate;
    private int status;
    private String email;
    private String password;

    public User() {

    }

    public User(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.name = userDTO.getName();
        this.lastName = userDTO.getLastName();
        this.idNumber = userDTO.getIdNumber();
        this.idFrontImageUrl = userDTO.getIdFrontImageUrl();
        this.idBackImageUrl = userDTO.getIdBackImageUrl();
        this.firstAddress = userDTO.getFirstAddress();
        this.secondAddress = userDTO.getSecondAddress();
        this.postalCode = userDTO.getPostalCode();
        this.birthDate = userDTO.getBirthDate();
        this.status = userDTO.getStatus();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdFrontImageUrl() {
        return idFrontImageUrl;
    }

    public void setIdFrontImageUrl(String idFrontImageUrl) {
        this.idFrontImageUrl = idFrontImageUrl;
    }

    public String getIdBackImageUrl() {
        return idBackImageUrl;
    }

    public void setIdBackImageUrl(String idBackImageUrl) {
        this.idBackImageUrl = idBackImageUrl;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
