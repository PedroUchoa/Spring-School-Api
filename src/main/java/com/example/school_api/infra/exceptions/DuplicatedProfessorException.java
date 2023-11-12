package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Já existe um Professor com esse nome")
public class DuplicatedProfessorException extends Exception{

    public DuplicatedProfessorException(String name){
        super("Já existe um Professor com o nome: " + name);
    }

}
