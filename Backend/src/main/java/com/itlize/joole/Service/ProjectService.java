package com.itlize.joole.Service;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project creatProject(Project project);

    Project findByProjectId(Long projectId);

    List<Project> findAllByUser(User user);

    void deleteProjectByProjectId(Long projectId);

    //update
    void updateProject(Project project);
}
