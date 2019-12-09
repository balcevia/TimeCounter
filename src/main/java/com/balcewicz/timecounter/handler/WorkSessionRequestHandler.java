package com.balcewicz.timecounter.handler;

import com.balcewicz.timecounter.model.request.WorkSessionRequest;
import com.balcewicz.timecounter.service.WorkSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WorkSessionRequestHandler extends AbstractValidationHandler<WorkSessionRequest, Validator> {

    private final WorkSessionService workSessionService;

    public WorkSessionRequestHandler(WorkSessionService workSessionService, Validator validator) {
        super(WorkSessionRequest.class, validator);
        this.workSessionService = workSessionService;
    }

    @Override
    protected Mono<ServerResponse> processBody(WorkSessionRequest validRequest, ServerRequest request) {
        return this.workSessionService.saveWorkSession(validRequest);
    }

}
