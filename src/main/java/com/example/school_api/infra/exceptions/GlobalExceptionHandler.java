package com.example.school_api.infra.exceptions;

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

    @ExceptionHandler(GradesNotFoundException.class)
    public ResponseEntity<String> handleGradesNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(DuplicatedSubjectException.class)
    public ResponseEntity<String> handleDuplicatedSubjectException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(DuplicatedProfessorException.class)
    public ResponseEntity<String> handleDuplicatedProfessorException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(ProfessorNotFoundException.class)
    public ResponseEntity<String> handleProfessorNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(ClassroomNotFoundException.class)
    public ResponseEntity<String> handleClassroomNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(GeneralNotFoundException.class)
    public ResponseEntity<String> handleGeneralNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(GeneralDuplicatedException.class)
    public ResponseEntity<String> handleGeneralDuplicatedException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(ClassroomDuplicatedException.class)
    public ResponseEntity<String> handleClassroomDuplicatedException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(AdministrationNotFoundException.class)
    public ResponseEntity<String> handleAdministrationNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }

    @ExceptionHandler(DuplicatedLoginException.class)
    public ResponseEntity<String> handleDuplicatedLoginException(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage() + "\n" + ex.getClass());
    }

}
