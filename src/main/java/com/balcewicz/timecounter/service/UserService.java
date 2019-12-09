package com.balcewicz.timecounter.service;

import com.balcewicz.timecounter.model.User;
import com.balcewicz.timecounter.model.api.ApiUser;
import com.balcewicz.timecounter.model.request.postrequest.UserPostRequest;
import com.balcewicz.timecounter.model.request.putrequest.UserPutRequest;
import com.balcewicz.timecounter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<ApiUser> fetchAllUsers() {
        return userRepository.findAll().map(ApiUser::apply);
    }

    public Mono<User> saveNewUser(UserPostRequest request) {
        return userRepository.save(User.apply(request));
    }

    public Mono<User> updateUser(UserPutRequest request) {
        return userRepository.save(User.apply(request));
    }

}
