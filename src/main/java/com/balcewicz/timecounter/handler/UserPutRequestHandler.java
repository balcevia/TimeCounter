package com.balcewicz.timecounter.handler;

import com.balcewicz.timecounter.model.request.putrequest.UserPutRequest;
import com.balcewicz.timecounter.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserPutRequestHandler extends AbstractValidationHandler<UserPutRequest, Validator> {

    private final UserService userService;

    public UserPutRequestHandler(UserService userService, Validator validator) {
        super(UserPutRequest.class, validator);
        this.userService = userService;
    }

    @Override
    public Mono<ServerResponse> processBody(UserPutRequest updatedUser, ServerRequest request) {
        return userService.updateUser(updatedUser).flatMap(u -> ServerResponse.status(HttpStatus.OK).build());
    }
}
