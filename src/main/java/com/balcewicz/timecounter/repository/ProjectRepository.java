package com.balcewicz.timecounter.repository;

import com.balcewicz.timecounter.model.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProjectRepository extends ReactiveMongoRepository<Project, String> {}