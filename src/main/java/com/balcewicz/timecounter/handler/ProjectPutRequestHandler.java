package com.balcewicz.timecounter.handler;


import com.balcewicz.timecounter.model.request.putrequest.ProjectPutRequest;
import com.balcewicz.timecounter.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProjectPutRequestHandler extends AbstractValidationHandler<ProjectPutRequest, Validator>{

    private final ProjectService projectService;

    public ProjectPutRequestHandler(ProjectService projectService, Validator validator) {
        super(ProjectPutRequest.class, validator);
        this.projectService = projectService;
    }

    @Override
    public Mono<ServerResponse> processBody(ProjectPutRequest validBody, ServerRequest request) {
        return projectService.updateProject(validBody).flatMap(p -> ServerResponse.status(HttpStatus.OK).build());
    }
}
