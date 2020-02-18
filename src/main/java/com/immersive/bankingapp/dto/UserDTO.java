package com.immersive.bankingapp.dto;

import com.immersive.bankingapp.model.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int userId;

    private String name;

    private String lastName;

    private String idNumber;

    private String idFrontImageUrl;

    private String idBackImageUrl;

    private String firstAddress;

    private String secondAddress;

    private int postalCode;

    private String phoneNumber;

    private LocalDate birthDate;

    private int status;

    private String email;

    private String password;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<AccountDTO> accounts;

    public UserDTO() {
    }

    public UserDTO(User newUser) {
        this.userId = newUser.getUserId();
        this.name = newUser.getName();
        this.lastName = newUser.getLastName();
        this.idNumber = newUser.getIdNumber();
        this.idFrontImageUrl = newUser.getIdFrontImageUrl();
        this.idBackImageUrl = newUser.getIdBackImageUrl();
        this.firstAddress = newUser.getFirstAddress();
        this.secondAddress = newUser.getSecondAddress();
        this.phoneNumber = newUser.getPhoneNumber();
        this.postalCode = newUser.getPostalCode();
        this.birthDate = newUser.getBirthDate();
        this.status = newUser.getStatus();
        this.email = newUser.getEmail();
        this.password = newUser.getPassword();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }
}
