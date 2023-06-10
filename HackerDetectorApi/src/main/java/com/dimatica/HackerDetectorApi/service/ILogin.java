package com.dimatica.HackerDetectorApi.service;

import com.dimatica.HackerDetectorApi.entities.User;

import java.util.List;

public interface ILogin {
    public List<User> login(String username, String password);
}
