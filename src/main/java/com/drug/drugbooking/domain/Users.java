package com.drug.drugbooking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence_name",
            allocationSize = 1
    )
    private int userId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;

    public Users() {
    }
    public Users(int userId, String fullName, String phoneNumber, String email, String password) {
        this.userId = userId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
