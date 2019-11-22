package com.balcewicz.timecounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class TimeCounterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeCounterApplication.class, args);
    }

}
