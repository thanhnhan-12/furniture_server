package com.furniro.furniture.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class RestError {
    private String httpStatus;
    private String message;
}
