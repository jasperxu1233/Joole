package com.itlize.joole.Controller;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.User;
import com.itlize.joole.Service.ProductService;
import com.itlize.joole.Service.ProjectProductService;
import com.itlize.joole.Service.ProjectService;
import com.itlize.joole.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {        //NOT BEEN TESTED


    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectProductService projectProductService;

    //NOT DONE
    private User getCurrentUser(Principal principal) {
        //authentication stuff
        return userService.findByUsername(principal.getName());
    }

    @GetMapping("/getAllProject")
    public ResponseEntity<?> getAllProjects(Principal principal) {
        User currentUser = getCurrentUser(principal);
        List<Project> projects = projectService.findAllByUser(currentUser);

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/getProject")
    public ResponseEntity<?> getProject(@RequestParam(name = "projectId") Long projectId)  {
        Project project = projectService.findByProjectId(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

//    @PostMapping("/addProject")
//    public ResponseEntity<?> addProject(Principal principal,
//                                        @RequestParam(name = "projectName") String projectName) {
//        User currentUser = getCurrentUser(principal);
//        Project project = projectService.creatProject(currentUser, projectName);
//
//        return new ResponseEntity<>(project, HttpStatus.CREATED);
//    }

    @PostMapping("/deleteProject")
    public ResponseEntity<?> deleteProject(Principal principal,
            @RequestParam(name = "projectId") Long projectId) {
        User currentUser = getCurrentUser(principal);
        projectService.deleteProjectByProjectId(projectId);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

//    @PostMapping("/deleteAllProject")
//    public ResponseEntity<?> deleteAllProjects(Principal principal) {
//        User currentUser = getCurrentUser(principal);
//
//        List<Project> projects = projectService.deleteAllProject(currentUser);
//
//        return new ResponseEntity<>(projects, HttpStatus.OK);
//    }

    @PostMapping("/updateProject")
    public void updateProject() {

    }

    @PostMapping("/addProductToProject")
    public void addProductToProject() {

    }

    @PostMapping("/deleteProductFromProject")
    public void deleteProductFromProject() {

    }

    @PostMapping("/getAllProjectProductByProjectId")
    public  void getAllProjectProductByProjectId(Long projectId) {

    }

    @PostMapping("/getAllProjectProductByProductId")
    public  void getAllProjectProductByProductId(Long productId) {


    }
}
