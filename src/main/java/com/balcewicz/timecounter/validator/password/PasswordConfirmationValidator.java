package com.balcewicz.timecounter.validator.password;

import com.balcewicz.timecounter.model.EntityWithPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmationValidator implements ConstraintValidator<PasswordConfirmationConstraint, EntityWithPassword> {

    @Override
    public void initialize(PasswordConfirmationConstraint constraint) {
    }

    @Override
    public boolean isValid(EntityWithPassword user, ConstraintValidatorContext ctx) {
        return user.getPassword().equals(user.getConfirmation());
    }
}
