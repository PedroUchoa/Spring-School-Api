package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Já existe um administration ativo com esse nome")
public class DuplicatedAdministrationException extends Exception {

    public DuplicatedAdministrationException(String name){
        super("Já existe um administrador ativo com o nome: " + name);
    }


}
