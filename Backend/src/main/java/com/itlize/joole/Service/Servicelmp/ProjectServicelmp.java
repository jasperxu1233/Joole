package com.itlize.joole.Service.Servicelmp;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.User;
import com.itlize.joole.Repository.ProjectRepository;
import com.itlize.joole.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServicelmp implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project creatProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findByProjectId(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @Override
    public Optional<List<Project>> findAllByOwner(User user) {
        return projectRepository.findAllByOwner(user);
    }

    @Override
    public Optional<List<Project>> deleteProjectsByOwner(User user) {
        return projectRepository.deleteProjectsByOwner(user);
    }
}
