package com.furniro.furniture.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoWhitespaceValidator implements ConstraintValidator<NoWhitespace, String> {
    @Override
    public void initialize(NoWhitespace constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        System.out.println("Value: " + value.contains(" "));
        System.out.println("Value: " + (value != null ? value.contains(" ") : "null"));
        return value != null && !value.contains(" ");
    }
}
