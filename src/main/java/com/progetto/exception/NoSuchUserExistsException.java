package com.progetto.exception;

public class NoSuchUserExistsException extends RuntimeException {
    public NoSuchUserExistsException(String message) {
        super(message);
    }
}
