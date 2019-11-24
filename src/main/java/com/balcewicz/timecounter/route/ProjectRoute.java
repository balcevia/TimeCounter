package com.balcewicz.timecounter.route;

import com.balcewicz.timecounter.handler.ProjectHandler;
import com.balcewicz.timecounter.handler.ProjectPostRequestHandler;
import com.balcewicz.timecounter.handler.ProjectPutRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@AllArgsConstructor
public class ProjectRoute {

    private static final String URI = "/projects";

    @Bean
    RouterFunction<ServerResponse> composedProjectsRoutes(final ProjectPostRequestHandler postHandler,
                                                          final ProjectPutRequestHandler putHandler,
                                                          final ProjectHandler projectHandler) {
        return route(POST(URI), postHandler::handleRequest)
                .andRoute(PUT(URI), putHandler::handleRequest)
                .andRoute(GET(URI), projectHandler::fetchAllProjects);
    }
}
