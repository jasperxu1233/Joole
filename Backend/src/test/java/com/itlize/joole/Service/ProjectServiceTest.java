package com.itlize.joole.Service;

import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;
    UserService userService;

    @Test
    void creatProject() {
//        User user1 = new User("project.user1", "111", "basic");
//        userService.createUser(user1);
//
//        Project project1 = new Project();
//        project1.setProjectName("project.test1");
//        project1.setId(1L);
//        project1.setUser(user1);
//
//        projectService.creatProject(project1);
//
//        User user2 = new User("project.user2", "222", "admin");
//        userService.createUser(user2);
//        Project project2 = new Project(2L, "project.user2", user2);
//        projectService.creatProject(project2);
//
//        System.out.println(project1);
//        System.out.println(project2);
//
//        Assertions.assertNotNull(project1);
//        Assertions.assertNotNull(project2);
    }

    @Test
    void findByProjectId() {
    }

    @Test
    void findAllByUser() {
    }

    @Test
    void deleteProjectsByUser() {
    }
}