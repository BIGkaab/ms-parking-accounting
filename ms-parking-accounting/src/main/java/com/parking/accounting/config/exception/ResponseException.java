package com.parking.accounting.config.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseException {

    private final String message;

    public ResponseException(String message){
        this.message = message;
    }
}
