package com.dimatica.HackerDetectorApi.controller;


import com.dimatica.HackerDetectorApi.entities.UserData;
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
public class LoginController {

    @Autowired
    ILogin loginService;

    Map<String, String> response = new HashMap<String, String>();

    @PostMapping(path = "/")
    public ResponseEntity login(@RequestBody UserData user){

        String token = loginService.login(user);
        if( token!= null){
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        response.put("error", HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
