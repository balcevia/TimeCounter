package com.balcewicz.timecounter.security;

import com.balcewicz.timecounter.model.Role;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private final JWTUtil jwtUtil;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();
        String username;

        try {
            username = jwtUtil.getUsernameFromToken(authToken);
        } catch(Exception e) {
            username = null;
        }

        if(username != null && jwtUtil.validateToken(authToken)) {
            Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
            List<Role> roles = new ArrayList<>();
            claims.get("role", List.class).forEach(role -> roles.add(Role.valueOf(role.toString())));
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
                    roles.stream().map(authority ->  new SimpleGrantedAuthority(authority.name())).collect(Collectors.toList()));
            return Mono.just(auth);
        } else {
            return Mono.empty();
        }
    }
}
