package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Notas não encontradas")
public class GradesNotFoundException extends Exception {

    public GradesNotFoundException(){
        super("Notas não encontradas");
    }

}
