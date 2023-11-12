package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Já existe esse subject")
public class DuplicatedSubjectException extends Exception {
    public DuplicatedSubjectException(String subjectName) {
        super("Já existe o subject " + subjectName);
    }
}
