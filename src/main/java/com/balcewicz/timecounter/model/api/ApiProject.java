package com.balcewicz.timecounter.model.api;

import com.balcewicz.timecounter.model.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApiProject {
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private Set<ApiUser> userIds;

    public static ApiProject apply(Project project, Set<ApiUser> users) {
        return new ApiProject(project.getId(), project.getName(), project.getDescription(), project.getCreationDate(), users);
    }
}
