package com.balcewicz.timecounter.handler;

import com.balcewicz.timecounter.model.request.postrequest.UserPostRequest;
import com.balcewicz.timecounter.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserPostRequestHandler extends AbstractValidationHandler<UserPostRequest, Validator> {

    private UserService userService;

    public UserPostRequestHandler(UserService userService, Validator validator) {
        super(UserPostRequest.class, validator);
        this.userService = userService;
    }

    @Override
    public Mono<ServerResponse> processBody(UserPostRequest newUser, ServerRequest request) {
        return userService.saveNewUser(newUser).flatMap(u -> ServerResponse.status(HttpStatus.CREATED).build());
    }
}
