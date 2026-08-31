package com.DevSeniorAugusto.campusFlow.common.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}