package com.balcewicz.timecounter.model.postrequest;


import com.balcewicz.timecounter.model.EntityWithPassword;
import com.balcewicz.timecounter.model.Role;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@NoArgsConstructor
public class UserPostRequest extends EntityWithPassword {
    @NotEmpty
    private String username;

    @NotEmpty
    private Set<Role> roles;

    public UserPostRequest(@NotEmpty String username, @NotEmpty Set<Role> roles,
                          @NotEmpty String password, @NotEmpty String confirmation) {
        this.username = username;
        this.roles = roles;
        super.setPassword(password);
        super.setConfirmation(confirmation);
    }

    public String getUsername() {
        return username;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
