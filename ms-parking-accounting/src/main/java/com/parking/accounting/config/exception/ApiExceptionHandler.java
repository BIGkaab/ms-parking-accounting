package com.parking.accounting.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> badRequestException(BadRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ResponseException responseException = new ResponseException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(responseException, badRequest);
    }

    @ExceptionHandler(value = InternalServerErrorException.class)
    public ResponseEntity<Object> internalServerErrorException(InternalServerErrorException e){
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
        ResponseException responseException = new ResponseException(
                e.getMessage(),
                internalServerError,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(responseException, internalServerError);
    }
}
