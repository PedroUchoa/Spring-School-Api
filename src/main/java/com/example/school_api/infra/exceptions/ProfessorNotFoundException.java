package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Professor não encontrado")
public class ProfessorNotFoundException extends Exception{

    public ProfessorNotFoundException(){
        super("Professor não encontrado. Por Favor tente novamente");
    }

}
