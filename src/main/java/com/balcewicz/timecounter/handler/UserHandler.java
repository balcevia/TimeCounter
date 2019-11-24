package com.balcewicz.timecounter.handler;

import com.balcewicz.timecounter.model.api.ApiUser;
import com.balcewicz.timecounter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class UserHandler {

    private final UserService userService;

    public Mono<ServerResponse> fetchAllUsers(ServerRequest request) {
        return ok().body(fromPublisher(userService.fetchAllUsers(), ApiUser.class));
    }
}
