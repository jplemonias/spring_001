package com.testjp.TestApp.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ErrorForm extends RuntimeException {
    public ErrorForm(String s) {
        super(s);
    }
}