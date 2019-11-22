package com.balcewicz.timecounter.service;

import com.balcewicz.timecounter.model.api.ApiUser;
import com.balcewicz.timecounter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<ApiUser> fetchAllUsers() {
        return userRepository.findAll().map(ApiUser::apply);
    }

}
