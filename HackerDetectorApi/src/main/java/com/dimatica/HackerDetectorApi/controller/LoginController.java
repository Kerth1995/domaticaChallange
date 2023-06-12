package com.dimatica.HackerDetectorApi.controller;


import com.dimatica.HackerDetectorApi.entities.UserData;
import com.dimatica.HackerDetectorApi.service.ILogin;
import com.dimatica.HackerDetectorApi.utilities.funciones.FuncionesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {

    @Autowired
    ILogin loginService;

    Map<String, String> response = new HashMap<String, String>();

    @PostMapping(path = "login")
    public ResponseEntity login(@RequestBody UserData user){

        String token = loginService.login(user);
        if( token!= null){
            response.put("token", token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("error", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "calctiempo")
    public ResponseEntity calcularTiempo() throws InterruptedException {
        System.out.println();
        response.put("tiempo minutos", Integer.toString(FuncionesComunes.calcularTiemporfc2822()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
