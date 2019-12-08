package com.balcewicz.timecounter.model;

import com.balcewicz.timecounter.validator.password.PasswordConfirmationConstraint;
import com.balcewicz.timecounter.validator.password.PasswordConstraint;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@PasswordConfirmationConstraint
public abstract class EntityWithPassword {

    @NotEmpty
    @PasswordConstraint
    private String password;

    @NotEmpty
    private String confirmation;
}
