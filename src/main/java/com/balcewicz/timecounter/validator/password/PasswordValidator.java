package com.balcewicz.timecounter.validator.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    @Override
    public void initialize(PasswordConstraint passwordConstraint){}

    @Override
    public boolean isValid(String password, ConstraintValidatorContext ctx) {
        return password != null &&
                password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[!#$%@]))") &&
                password.length() > 6;
    }
}
