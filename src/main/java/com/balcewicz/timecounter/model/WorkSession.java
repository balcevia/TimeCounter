package com.balcewicz.timecounter.model;

import com.balcewicz.timecounter.model.request.WorkSessionRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "worksession")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WorkSession extends BaseEntity {

    public WorkSession(String id, String userId, String projectId, Instant startDate, Instant endDate) {
        this.setId(id);
        this.userId = userId;
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private String userId;
    private String projectId;
    private Instant startDate;
    private Instant endDate;

    public static WorkSession apply(WorkSessionRequest request) {
        return new WorkSession(request.getUserId(), request.getProjectId(), Instant.now(), null);
    }

}
