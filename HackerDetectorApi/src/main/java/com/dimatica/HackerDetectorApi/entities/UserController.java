package com.dimatica.HackerDetectorApi.entities;

import org.springframework.stereotype.Component;

public class UserController {

    //@Value("${login_username}")
    private String username;

    //@Value("${login_password}")
    private String password;

    private String ipAddress;

    public UserController(String username, String password, String ipAddress) {
        this.username = username;
        this.password = password;
        this.ipAddress = ipAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdAddress() {
        return ipAddress;
    }

    public void setIdAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "UserController{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
