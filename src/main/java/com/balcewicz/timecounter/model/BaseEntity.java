package com.balcewicz.timecounter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public abstract class BaseEntity {
    @Id
    private String id;
}
