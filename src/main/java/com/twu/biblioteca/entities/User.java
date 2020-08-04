package com.twu.biblioteca.entities;

public class User {

    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNum;

    public User(String id, String password, String name, String email, String phoneNum) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", email: " + email +
                ", phone number: " + phoneNum;
    }
}
