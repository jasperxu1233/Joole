package com.itlize.joole.Service;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.User;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project creatProject(Project project);

    Project findByProjectId(Long projectId);

    Optional<List<Project>> findAllByUser(User user);

    Optional<List<Project>> deleteProjectsByUser(User user);
}
