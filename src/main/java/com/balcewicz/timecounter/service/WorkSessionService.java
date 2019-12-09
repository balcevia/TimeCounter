package com.balcewicz.timecounter.service;

import com.balcewicz.timecounter.model.WorkSession;
import com.balcewicz.timecounter.model.request.WorkSessionRequest;
import com.balcewicz.timecounter.model.request.WorkSessionRequestType;
import com.balcewicz.timecounter.repository.WorkSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@AllArgsConstructor
public class WorkSessionService {

    private final WorkSessionRepository workSessionRepository;

    public Mono<ServerResponse> saveWorkSession(WorkSessionRequest request) {
        Mono<WorkSession> workSession = workSessionRepository.findByUserIdAndProjectIdAndEndDateIsNull(request.getUserId(), request.getProjectId());
        if (request.getType() == WorkSessionRequestType.START) {
            return workSession.flatMap(ws -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
                    .switchIfEmpty(Mono.defer(() ->
                            workSessionRepository.save(WorkSession.apply(request)).flatMap(savedSession -> ServerResponse.status(HttpStatus.OK).build())
                    ));
        } else {
            return workSession.flatMap(ws ->
                    workSessionRepository.save(new WorkSession(ws.getId(), ws.getUserId(), ws.getProjectId(), ws.getStartDate(), Instant.now()))
                            .flatMap(updated -> ServerResponse.status(HttpStatus.OK).build())
            ).switchIfEmpty(Mono.defer(() -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
        }
    }
}
