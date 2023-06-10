package com.dimatica.HackerDetectorApi.service.impl;

import com.dimatica.HackerDetectorApi.entities.User;
import com.dimatica.HackerDetectorApi.repository.ILoginRepository;
import com.dimatica.HackerDetectorApi.service.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginImpl implements ILogin {

    @Autowired
    ILoginRepository loginRepository;

    @Override
    public List<User> login(String username, String password) {
        return loginRepository.findByUsernameAndPassword(username, password);
    }
}
