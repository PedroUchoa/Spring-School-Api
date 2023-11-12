package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "General Service não encontrado")
public class GeneralNotFoundException extends Exception{

    public GeneralNotFoundException(){
        super("General Service não encontrado. Por Favor tente novamente");
    }

}
