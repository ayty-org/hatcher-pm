package org.ayty.hatcher.api.v1.project.service;

import lombok.RequiredArgsConstructor;

import org.ayty.hatcher.api.v1.project.entity.Project;
import org.ayty.hatcher.api.v1.project.exception.ProjectNotFoundException;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FindProjectByIdServiceImpl implements FindProjectByIdService {

    private final ProjectRepository projectRepository;

    public Optional<Project> findById(Long id) {
        return Optional.ofNullable(projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Doesn't exist project with this id!")));
    }
}
