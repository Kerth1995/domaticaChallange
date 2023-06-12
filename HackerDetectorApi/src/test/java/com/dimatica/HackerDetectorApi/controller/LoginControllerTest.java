package com.dimatica.HackerDetectorApi.controller;

import com.dimatica.HackerDetectorApi.entities.UserData;
import com.dimatica.HackerDetectorApi.service.ILogin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoginControllerTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    ILogin loginService;

    UserData userData;

    @BeforeAll
    void setup(){
        MockitoAnnotations.openMocks(this);
        userData = new UserData("userdimaticaprueba", "$userdimaticaprueba_1234*", "192.168.0.1");
    }

    @Test
    void testLogin(){
        ResponseEntity<Object> actual = new ResponseEntity<>("Hola", HttpStatus.OK);
        String token = UUID.randomUUID().toString();
        Mockito.when(loginService.login(userData)).thenReturn(token);
        ResponseEntity  response = loginController.login(userData);
        Assertions.assertEquals(response.getStatusCode(), actual.getStatusCode());
    }

    @Test
    void testLoginError(){
        ResponseEntity<Object> expected = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Mockito.when(loginService.login(userData)).thenReturn(null);
        ResponseEntity  response = loginController.login(userData);
        Assertions.assertEquals(response.getStatusCode(), expected.getStatusCode());
    }

    @Test
    void testCalcularTiempo() throws InterruptedException {
        ResponseEntity<Object> expected = new ResponseEntity<>(1, HttpStatus.OK);
        ResponseEntity  response = loginController.calcularTiempo();
        Assertions.assertEquals(response.getStatusCode(), expected.getStatusCode());
    }

    @Test
    void testCalcularTiempoError() throws InterruptedException {
        ResponseEntity<Object> expected = new ResponseEntity<>(1, HttpStatus.NOT_FOUND);
        ResponseEntity  response = loginController.calcularTiempo();
        Assertions.assertNotEquals(response.getStatusCode(), expected.getStatusCode());
    }
}