package com.dimatica.HackerDetectorApi.controller;


import com.dimatica.HackerDetectorApi.entities.UserController;
import com.dimatica.HackerDetectorApi.entities.User;
import com.dimatica.HackerDetectorApi.service.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("login")
@CrossOrigin(origins = "http://localhost:4200/")
public class Login {

    @Autowired
    ILogin loginService;

    Map<String, String> response = new HashMap<String, String>();

    @PostMapping(path = "/")
    public ResponseEntity login(@RequestBody UserController user){

        if(loginService.login(user.getUsername(), user.getPassword()).size()>0){
            response.put("token", "Hola");
            return ResponseEntity.ok(response);
        }
        response.put("error", "Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
