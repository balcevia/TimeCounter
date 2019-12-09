package com.balcewicz.timecounter.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WorkSessionRequest {
    @NotEmpty
    private String userId;
    @NotEmpty
    private String projectId;
    @NotNull
    private WorkSessionRequestType type;
}