package com.balcewicz.timecounter.handler;

import com.balcewicz.timecounter.model.request.postrequest.ProjectPostRequest;
import com.balcewicz.timecounter.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProjectPostRequestHandler extends AbstractValidationHandler<ProjectPostRequest, Validator> {

    private final ProjectService projectService;

    public ProjectPostRequestHandler(ProjectService projectService, Validator validator) {
        super(ProjectPostRequest.class, validator);
        this.projectService = projectService;
    }

    @Override
    protected Mono<ServerResponse> processBody(ProjectPostRequest validRequest, ServerRequest request) {
        return projectService.saveNewProject(validRequest).flatMap(p -> ServerResponse.status(HttpStatus.CREATED).build());
    }
}
