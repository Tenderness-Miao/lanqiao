package com.example.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageException extends RuntimeException {
    private Integer code;

    public PageException() {
    }

    public PageException(String message, Integer code) {
        super(message);
        this.code = code;
    }

}