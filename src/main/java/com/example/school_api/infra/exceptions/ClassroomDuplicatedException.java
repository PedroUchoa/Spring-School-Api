package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Já existe um sala com esse nome")
public class ClassroomDuplicatedException extends Exception{

    public ClassroomDuplicatedException(String name){
        super("Já existe uma sala com o nome: " + name);
    }

}
