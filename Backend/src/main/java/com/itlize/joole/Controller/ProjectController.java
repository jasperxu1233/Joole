package com.itlize.joole.Controller;

import com.itlize.joole.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllProject")
    public void getAllProjects() {

    }

    @GetMapping("/getProject")
    public void getProject() {

    }

    @PostMapping("/addProject")
    public void addProject() {

    }

    @PostMapping("/deleteProject")
    public void deleteProject() {

    }

    @PostMapping("/deleteAllProject")
    public void deleteAllProjects() {

    }

    @PostMapping("/updateProject")
    public void updateProject() {

    }

}
