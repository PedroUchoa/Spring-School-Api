package com.example.school_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Essa entidade já está desativada")
public class IsAlreadyDesactivedException extends Exception{

    public IsAlreadyDesactivedException(String name){
        super(name + " já está desativado(a)");
    }


}
