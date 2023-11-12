package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Esse estudante já possui um Report para esse semestre")
public class SemesterDuplicatedException extends Exception{

    public SemesterDuplicatedException(String semester){
        super("Esse estudante já possui um report para o semester " + semester);
    }

}
