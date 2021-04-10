package com.desafioStoom.exception;

public class GoogleResponseException extends RuntimeException {

    public GoogleResponseException(String message) {
        super(message);
    }

    public GoogleResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
