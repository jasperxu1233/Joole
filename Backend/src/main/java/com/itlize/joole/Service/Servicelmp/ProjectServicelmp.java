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
    public List<Project> findAllByUser(User user) {
        return projectRepository.findAllByUser(user).orElse(null);
    }

    @Override
    public void deleteProjectByProjectId(Long id) {
        projectRepository.deleteProjectById(id);
    }

    //new
    @Override
    public void updateProject(Project projectUpdated) {
        Project projectFromDB = projectRepository.findById(projectUpdated.getId()).orElse(null);
        projectFromDB.setProjectName(projectUpdated.getProjectName());
        projectRepository.save(projectFromDB);
    }
}
