package com.example.school_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatedStudentException.class)
    public ResponseEntity<String> handleDuplicatedStudentException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(IsAlreadyDesactivedException.class)
    public ResponseEntity<String> handleIsAlreadyDesactivedException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }


}
