package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Materia não encontrada")
public class SubjectNotFoundException extends Exception{

    public SubjectNotFoundException(){
        super("Materia não encontrada. Por Favor tente novamente");
    }

}
