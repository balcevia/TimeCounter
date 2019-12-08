package com.balcewicz.timecounter.model.putrequest;

import com.balcewicz.timecounter.model.EntityWithPassword;
import com.balcewicz.timecounter.model.Role;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@NoArgsConstructor
public class UserPutRequest extends EntityWithPassword {
    @NotEmpty
    private String id;
    @NotEmpty
    private String username;
    @NotEmpty
    private Set<Role> roles;

    public UserPutRequest(@NotEmpty String id, @NotEmpty String username, @NotEmpty Set<Role> roles,
                          @NotEmpty String password, @NotEmpty String confirmation) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        super.setPassword(password);
        super.setConfirmation(confirmation);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
