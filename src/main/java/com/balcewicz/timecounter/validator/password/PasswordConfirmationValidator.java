package com.balcewicz.timecounter.validator.password;

import com.balcewicz.timecounter.model.RequestWithPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmationValidator implements ConstraintValidator<PasswordConfirmationConstraint, RequestWithPassword> {

    @Override
    public void initialize(PasswordConfirmationConstraint constraint) {
    }

    @Override
    public boolean isValid(RequestWithPassword user, ConstraintValidatorContext ctx) {
        return user.getPassword().equals(user.getConfirmation());
    }
}
