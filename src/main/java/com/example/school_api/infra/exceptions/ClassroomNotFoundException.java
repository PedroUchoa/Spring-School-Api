package com.example.school_api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Sala não encontrada")
public class ClassroomNotFoundException extends Exception{

    public ClassroomNotFoundException(){
        super("Sala não encontrada. Por Favor tente novamente");
    }

}
