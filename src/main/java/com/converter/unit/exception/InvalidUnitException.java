package com.converter.unit.exception;

import lombok.Getter;

@Getter
public class InvalidUnitException extends Exception {

    private final String msg;
    private final int status;

    public InvalidUnitException(String msg) {
        this.msg = msg;
        this.status = 500;
    }

    public InvalidUnitException(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }
}
