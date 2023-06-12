package com.dimatica.HackerDetectorApi.utilities.funciones;

import org.springframework.expression.ParseException;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class FuncionesComunes {

    public static String obtenerFechaEpoch(){
        return Long.toString(Instant.now().toEpochMilli());
    }


    public static int calcularTiemporfc2822() throws InterruptedException {
        Date firsDate =new Date();
        Thread.sleep(20000);
        Date secondDate =new Date();
        List<Date> dates = Arrays.asList(firsDate, firsDate);
        String pattern = "EEE, dd MMM yyyy HH:mm:ss Z"; //$NON-NLS-1$
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        int rpta = secondDate.getMinutes() - firsDate.getMinutes();
        //format.format(rpta)
        return rpta;
    }
}
