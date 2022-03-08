package com.itlize.joole.Service.Servicelmp;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.User;
import com.itlize.joole.Repository.ProjectRepository;
import com.itlize.joole.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServicelmp implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project creatProject(Project project) {//test_1

//        Project projectfromDB = projectRepository.findById(projectNew.getId());
//        if(projectfromDB == null){
//            System.out.println("no this project");
              return projectRepository.save(project);
//        }
//        return projectRepository.save(project);
//
//        System.out.println("delete the project " + project.getProjectName());
    }

    @Override
    public Project createProjectByProjectName(String projectName) {
        Project project = new Project();
        project.setProjectName(projectName);

        Project projectfromDB = projectRepository.findByProjectName(projectName);
        if(projectfromDB != null){
            System.out.println("This project already existed");
            return projectfromDB;
        }
        return projectRepository.save(project);
    }

    @Override
    public Project findByProjectId(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findAllByUser(User user) {
        return projectRepository.findAllByUser(user).orElse(null);
    }

    @Override
    public Project findByProjectName(String projectName) {
        return projectRepository.findByProjectName(projectName);
    }

    @Override
    @Transactional
    public void deleteProjectByProjectId(Long id) {
        Project project = projectRepository.getById(id);
        if(project == null){
            System.out.println("no this project");
        }
        System.out.println("delete the project " + project.getProjectName());
        projectRepository.deleteProjectById(id);
    }

    @Override
    @Transactional
    public void deleteProjectByProjectName(String projectName) {
        Project project = projectRepository.findByProjectName(projectName);
        if(project == null){
            System.out.println("no this project");
        }
        System.out.println("delete the project " + project.getProjectName());
        projectRepository.deleteByProjectName(projectName);
    }

    @Override
    @Transactional
    public List<Project> deleteAllByUser(User user) {
        return projectRepository.deleteAllByUser(user).orElse(null);
    }


    //new
    @Override
    public Project updateProject(String projectNameOld, String projectNameNew) {
        Project project = projectRepository.findByProjectName(projectNameOld);
        if(project == null){
            return null;
        }
        project.setProjectName(projectNameNew);
        return projectRepository.save(project);
    }
}
