package com.balcewicz.timecounter.route;

import com.balcewicz.timecounter.handler.WorkSessionRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@AllArgsConstructor
public class WorkSessionRoute {

    private static String URI = "work-sessions";

    @Bean
    RouterFunction<ServerResponse> composedWorkSessionRoutes(final WorkSessionRequestHandler workSessionRequestHandler) {
        return route(POST(URI), workSessionRequestHandler::handleRequest);
    }
}
