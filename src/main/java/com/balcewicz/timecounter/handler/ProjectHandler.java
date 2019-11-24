package com.balcewicz.timecounter.handler;

import com.balcewicz.timecounter.model.api.ApiProject;
import com.balcewicz.timecounter.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ProjectHandler {

    private final ProjectService projectService;

    public Mono<ServerResponse> fetchAllProjects(ServerRequest request) {
        return ok().body(fromPublisher(projectService.fetchAllProjects(), ApiProject.class));
    }
}
