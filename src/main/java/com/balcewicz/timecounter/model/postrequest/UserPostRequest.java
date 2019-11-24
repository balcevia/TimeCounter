package com.balcewicz.timecounter.model.postrequest;


import com.balcewicz.timecounter.model.Role;
import com.balcewicz.timecounter.validator.password.PasswordConfirmationConstraint;
import com.balcewicz.timecounter.validator.password.PasswordConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@PasswordConfirmationConstraint
public class UserPostRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    @PasswordConstraint
    private CharSequence password;
    @NotEmpty
    private CharSequence confirmation;
    @NotEmpty
    private Set<Role> roles;
}
