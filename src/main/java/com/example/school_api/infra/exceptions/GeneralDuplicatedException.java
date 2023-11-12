package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Já te um professor ativo com esse nome")
public class GeneralDuplicatedException extends Exception {
    public GeneralDuplicatedException(String name) {
        super("Já existe um professor ativo com o nome: " + name);
    }
}
