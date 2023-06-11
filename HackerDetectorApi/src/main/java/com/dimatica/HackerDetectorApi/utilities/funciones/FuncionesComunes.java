package com.dimatica.HackerDetectorApi.utilities.funciones;

import java.time.Instant;


public class FuncionesComunes {

    public static String obtenerFechaEpoch(){
        return Long.toString(Instant.now().toEpochMilli());
    }

}
