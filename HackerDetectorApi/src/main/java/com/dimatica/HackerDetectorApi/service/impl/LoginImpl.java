package com.dimatica.HackerDetectorApi.service.impl;

import com.dimatica.HackerDetectorApi.entities.Login;
import com.dimatica.HackerDetectorApi.entities.UserData;
import com.dimatica.HackerDetectorApi.repository.ILoginRepository;
import com.dimatica.HackerDetectorApi.repository.ISeguridadLogin;
import com.dimatica.HackerDetectorApi.service.IHackerDetector;
import com.dimatica.HackerDetectorApi.service.ILogin;
import com.dimatica.HackerDetectorApi.utilities.enums.Accion;
import com.dimatica.HackerDetectorApi.utilities.funciones.FuncionesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class LoginImpl implements ILogin {

    @Autowired
    ILoginRepository loginRepository;

    @Autowired
    ISeguridadLogin seguridadLogin;

    @Autowired
    IHackerDetector hackerDetectorService;

    @Override
    public String login(UserData user) {
        if(loginRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).size()>0){
            String token =  UUID.randomUUID().toString();
            String ip = hackerDetectorService.parseLine();
            Login login = new Login();
            if(!ip.isEmpty() || ip != null){
                login.setIp(ip);
                login.setAccion(Accion.SIGNIN_SUCCESS.getAccion());
                login.setUsername(user.getUsername());
                login.setToken(token);
                login.setFechaCreacion(FuncionesComunes.obtenerFechaEpoch());
                seguridadLogin.save(login);
            }else{
                login.setIp(ip);
                login.setAccion(Accion.SIGNIN_FAILURE.getAccion());
                login.setUsername(user.getUsername());
                login.setToken("NULL");
                login.setFechaCreacion(FuncionesComunes.obtenerFechaEpoch());
                seguridadLogin.save(login);
            }

            return token;
        }
        //response.put("error", "Not Found");
        return null;
    }
//select * from usuario;
//select * from login;


}
