package com.balcewicz.timecounter.validator.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordConfirmationValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConfirmationConstraint {
    String message() default "Passwords should match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
