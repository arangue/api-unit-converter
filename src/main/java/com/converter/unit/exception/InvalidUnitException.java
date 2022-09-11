package com.converter.unit.exception;

import lombok.Getter;

@Getter
public class InvalidUnitException extends Exception {

    private final int status;

    public InvalidUnitException(String msg) {
        super(msg);
        this.status = 500;
    }

    public InvalidUnitException(String msg, int status) {
        super(msg);
        this.status = status;
    }
}
