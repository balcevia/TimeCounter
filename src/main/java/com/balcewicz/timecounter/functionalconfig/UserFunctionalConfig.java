package com.balcewicz.timecounter.functionalconfig;

import com.balcewicz.timecounter.model.api.ApiUser;
import com.balcewicz.timecounter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@AllArgsConstructor
public class UserFunctionalConfig {

    private final UserService userService;

    @Bean
    RouterFunction<ServerResponse> composedRoutes() {
        return route(GET("/users"),
                request -> ok().body(userService.fetchAllUsers(), ApiUser.class));
    }
}
