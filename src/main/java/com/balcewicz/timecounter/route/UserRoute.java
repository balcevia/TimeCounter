package com.balcewicz.timecounter.route;

import com.balcewicz.timecounter.handler.UserHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@AllArgsConstructor
public class UserRoute {

    private static final String URI = "/users";

    @Bean
    RouterFunction<ServerResponse> composedUsersRoutes(final UserHandler handler) {
        return route(GET(URI), handler::fetchAllUsers);
    }
}
