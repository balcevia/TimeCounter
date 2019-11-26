package com.balcewicz.timecounter.model;

import com.balcewicz.timecounter.model.postrequest.UserPostRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends BaseEntity {

    private String username;

    private String password;

    private Set<Role> roles;

    public static User apply(UserPostRequest req) {
        return new User(req.getUsername(), req.getPassword(), req.getRoles());
    }
}
