package com.desafioStoom.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            EmptyResultDataAccessException.class,
            ObjectNotFoundException.class
    })
    public ResponseEntity errorNotFound(Exception e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity errorBadRequest() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(GoogleResponseException.class)
    public ResponseEntity errorGoogleClient() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
