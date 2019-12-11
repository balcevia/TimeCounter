package com.balcewicz.timecounter.model;

import com.balcewicz.timecounter.model.request.postrequest.UserPostRequest;
import com.balcewicz.timecounter.model.request.putrequest.UserPutRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends BaseEntity implements UserDetails {

    private String username;

    private String password;

    private Set<Role> roles;

    public static User apply(UserPostRequest req) {
        return new User(req.getUsername(), req.getPassword(), req.getRoles());
    }

    public static User apply(UserPutRequest req) {
        User updatedUser = new User(req.getUsername(), req.getPassword(), req.getRoles());
        updatedUser.setId(req.getId());
        return updatedUser;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(authority -> new SimpleGrantedAuthority(authority.name())).collect(Collectors.toList());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

}
