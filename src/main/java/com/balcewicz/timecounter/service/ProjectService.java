package com.balcewicz.timecounter.service;

import com.balcewicz.timecounter.model.Project;
import com.balcewicz.timecounter.model.api.ApiProject;
import com.balcewicz.timecounter.model.api.ApiUser;
import com.balcewicz.timecounter.model.postrequest.ProjectPostRequest;
import com.balcewicz.timecounter.model.putrequest.ProjectPutRequest;
import com.balcewicz.timecounter.repository.ProjectRepository;
import com.balcewicz.timecounter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public Mono<Project> saveNewProject(ProjectPostRequest project) {
        Project newProject = new Project(project.getName(), LocalDateTime.now(), project.getDescription(), project.getUserIds());
        return projectRepository.save(newProject);
    }

    public Mono<Project> updateProject(ProjectPutRequest project) {
        return projectRepository.findById(project.getId()).map(p ->
                new Project(p.getId(), project.getName(), p.getCreationDate(), project.getDescription(), project.getUserIds()))
        .flatMap(projectRepository::save);
    }

    public Flux<ApiProject> fetchAllProjects() {
        return projectRepository.findAll().flatMap(project -> userRepository.findAllById(project.getUserIds())
                    .map(ApiUser::apply).collectList()
                    .map(HashSet::new)
                    .map(users -> ApiProject.apply(project, users)));
    }
}
