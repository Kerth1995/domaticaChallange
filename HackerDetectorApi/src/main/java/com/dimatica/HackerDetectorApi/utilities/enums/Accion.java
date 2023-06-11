package com.dimatica.HackerDetectorApi.utilities.enums;


public enum Accion {
    SIGNIN_SUCCESS("SIGNIN_SUCCESS", 1),
    SIGNIN_FAILURE("SIGNIN_FAILURE", 2);

    private String accion;
    private Integer code;


    Accion(String accion, int code) {
        this.accion =  accion;
        this.code = code;
    }

    public String getAccion() {
        return accion;
    }

    public Integer getCode() {
        return code;
    }


}
