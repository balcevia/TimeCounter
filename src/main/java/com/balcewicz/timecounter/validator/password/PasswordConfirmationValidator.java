package com.balcewicz.timecounter.validator.password;

import com.balcewicz.timecounter.model.postrequest.UserPostRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmationValidator implements ConstraintValidator<PasswordConfirmationConstraint, UserPostRequest> {

    @Override
    public void initialize(PasswordConfirmationConstraint constraint) {}

    @Override
    public boolean isValid(UserPostRequest user, ConstraintValidatorContext ctx) {
        return user.getPassword().equals(user.getConfirmation());
    }
}
