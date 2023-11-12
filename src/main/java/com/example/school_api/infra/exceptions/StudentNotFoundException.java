package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Estudante não encontrado")
public class StudentNotFoundException extends Exception{

    public StudentNotFoundException(){
        super("Estudante não encontrado. Por Favor tente novamente");
    }

}
