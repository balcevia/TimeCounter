package com.balcewicz.timecounter.model.api;


import com.balcewicz.timecounter.model.Role;
import com.balcewicz.timecounter.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class ApiUser {
    private String id;
    private String username;
    private Set<Role> role;

    public static ApiUser apply(User user) {
        return new ApiUser(user.getId(), user.getUsername(), user.getRoles());
    }
}
