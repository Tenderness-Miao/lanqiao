package com.example.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonException extends RuntimeException {
    private Integer code;

    public JsonException() {
    }

    public JsonException(String message, Integer code) {
        super(message);
        this.code = code;
    }
    
    
}