package br.com.abctechservice.abctechserviceapi.handler.exception;

import lombok.Getter;

@Getter
public class OperatorNotFoundException extends RuntimeException {
    private String description;

    public OperatorNotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }
}