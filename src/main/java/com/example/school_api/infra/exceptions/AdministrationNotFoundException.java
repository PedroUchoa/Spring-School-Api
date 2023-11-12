package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Administration não encontrado(a)")
public class AdministrationNotFoundException extends Exception{

    public AdministrationNotFoundException(){
        super("Administration não encontrado(a). Por Favor tente novamente");
    }

}
