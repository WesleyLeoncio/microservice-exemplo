package com.ms.user.config.exeptions;

import org.springframework.validation.FieldError;

public record ErroValidacaoException(String campo, String msg) {
    public ErroValidacaoException(FieldError erro) {
        this(erro.getField(),erro.getDefaultMessage());
    }
}
