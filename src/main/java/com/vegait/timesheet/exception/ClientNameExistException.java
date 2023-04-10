package com.vegait.timesheet.exception;

public class ClientNameExistException extends RuntimeException{

    public ClientNameExistException(String message) {
        super(message);
    }
}
