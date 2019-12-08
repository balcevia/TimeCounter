package com.balcewicz.timecounter.repository;

import com.balcewicz.timecounter.model.WorkSession;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkSessionRepository extends ReactiveMongoRepository<WorkSession, String> {
}
