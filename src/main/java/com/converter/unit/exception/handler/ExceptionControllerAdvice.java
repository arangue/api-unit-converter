package com.converter.unit.exception.handler;

import com.converter.unit.dto.response.AppError;
import com.converter.unit.exception.InvalidUnitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

/*    @ExceptionHandler(InvalidUnitException.class)
    public ResponseEntity<?> handle(InvalidUnitException ex) {
        return new ResponseEntity<>(ex.getMsg(), HttpStatus.valueOf(ex.getStatus()));
    }*/

    @ExceptionHandler(InvalidUnitException.class)
    public ResponseEntity<?> handle(InvalidUnitException ex) {
        return buildResponse(HttpStatus.valueOf(ex.getStatus()), ex.getMessage());
    }

    private ResponseEntity<?> buildResponse(HttpStatus status, String msg) {
        return ResponseEntity.status(status).body(new AppError(msg));
    }
}