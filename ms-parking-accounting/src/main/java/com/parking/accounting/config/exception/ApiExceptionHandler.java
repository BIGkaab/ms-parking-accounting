package com.parking.accounting.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> badRequestException(BadRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ResponseException responseException = new ResponseException(
                e.getMessage()
        );
        return new ResponseEntity<>(responseException, badRequest);
    }

    @ExceptionHandler(value = InternalServerErrorException.class)
    public ResponseEntity<Object> internalServerErrorException(InternalServerErrorException e){
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
        ResponseException responseException = new ResponseException(
                e.getMessage()
        );
        return new ResponseEntity<>(responseException, internalServerError);
    }

    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity<Object> forbiddenException(ForbiddenException e){
        HttpStatus forbidden = HttpStatus.FORBIDDEN;
        ResponseException responseException = new ResponseException(
                e.getMessage()
        );
        return new ResponseEntity<>(responseException, forbidden);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity<Object> unauthorizedException(UnauthorizedException e){
        HttpStatus unauthorized = HttpStatus.UNAUTHORIZED;
        ResponseException responseException = new ResponseException(
                e.getMessage()
        );
        return new ResponseEntity<>(responseException, unauthorized);
    }
}
