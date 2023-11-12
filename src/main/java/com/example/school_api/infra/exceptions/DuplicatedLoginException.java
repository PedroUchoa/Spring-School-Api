package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Já tem um User com esse login")
public class DuplicatedLoginException extends Exception {

    public DuplicatedLoginException(String name){
        super("Já tem um user com esse o login: " + name);
    }

}
