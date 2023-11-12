package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Já existe um estudante com esse nome")
public class DuplicatedStudentException extends Exception{

    public DuplicatedStudentException(String name){
        super("Já existe um estudante com o nome: " + name);
    }

}
