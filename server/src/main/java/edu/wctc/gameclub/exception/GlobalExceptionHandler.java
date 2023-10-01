package edu.wctc.gameclub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(ResourceNotFoundException exception,
                                                                     ServletWebRequest request) {
        ExceptionResponse responseObject = new ExceptionResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                request.getRequest().getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseObject);
    }

    @ExceptionHandler(DuplicateRegistrationException.class)
    public ResponseEntity<ExceptionResponse> handleRegistrationException(DuplicateRegistrationException exception,
                                                                     ServletWebRequest request) {
        ExceptionResponse responseObject = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                request.getRequest().getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObject);
    }
}
