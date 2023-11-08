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
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(IsAlreadyDesactivedException.class)
    public ResponseEntity<String> handleIsAlreadyDesactivedException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<String> handleSubjectNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(ReportNotFoundException.class)
    public ResponseEntity<String> handleReportNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }
    @ExceptionHandler(SemesterDuplicatedException.class)
    public ResponseEntity<String> handleSemesterDuplicatedException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(SemesterNotFoundException.class)
    public ResponseEntity<String> handleSemesterNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }


}
