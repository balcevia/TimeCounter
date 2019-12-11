package com.balcewicz.timecounter.handler;

import com.balcewicz.timecounter.model.request.AuthRequest;
import com.balcewicz.timecounter.model.request.AuthResponse;
import com.balcewicz.timecounter.security.JWTUtil;
import com.balcewicz.timecounter.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class AuthHandler extends AbstractValidationHandler<AuthRequest, Validator> {

    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthHandler(UserService service, JWTUtil jwtUtil, PasswordEncoder passwordEncoder, Validator validator) {
        super(AuthRequest.class, validator);
        this.userService = service;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected Mono<ServerResponse> processBody(AuthRequest validBody, ServerRequest request) {
        return userService.fetchByUsername(validBody.getUsername()).flatMap(user -> {
            if(passwordEncoder.matches(validBody.getPassword(), user.getPassword())) {
                return ServerResponse.status(HttpStatus.OK).body(Mono.just(new AuthResponse(jwtUtil.generateToken(user))), AuthResponse.class);
            } else {
                return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).switchIfEmpty(ServerResponse.status(HttpStatus.UNAUTHORIZED).build());
    }
}
