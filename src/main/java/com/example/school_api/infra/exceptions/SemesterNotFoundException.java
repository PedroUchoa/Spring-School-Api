package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Semestre não encontrado")
public class SemesterNotFoundException extends Exception{

    public SemesterNotFoundException(){
        super("Semestre não encontrada. Por Favor tente novamente");
    }

}
