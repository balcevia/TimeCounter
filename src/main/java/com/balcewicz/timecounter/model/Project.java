package com.balcewicz.timecounter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Project extends BaseEntity {

    private String name;
    private LocalDateTime creationDate;
    private String description;
    private Set<String> userIds;

    public Project(String id, String name, LocalDateTime creationDate, String description, Set<String> userIds) {
        this.setId(id);
        this.name = name;
        this.creationDate = creationDate;
        this.description = description;
        this.userIds = userIds;
    }
}
