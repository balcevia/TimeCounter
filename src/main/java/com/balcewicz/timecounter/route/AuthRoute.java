package com.balcewicz.timecounter.route;

import com.balcewicz.timecounter.handler.AuthHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@AllArgsConstructor
public class AuthRoute {

    private static final String URI = "/login";

    @Bean
    RouterFunction<ServerResponse> composedAuthRoutes(final AuthHandler authHandler) {
        return route(POST(URI), authHandler::handleRequest);
    }
}
