package com.itlize.joole.Controller;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.ProjectProduct;
import com.itlize.joole.Entity.User;
import com.itlize.joole.Service.ProductService;
import com.itlize.joole.Service.ProjectProductService;
import com.itlize.joole.Service.ProjectService;
import com.itlize.joole.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    public ResponseEntity<?> getAllProjects( //get all projects from current user
//            Principal principal
    ) {
//        User currentUser = getCurrentUser(principal);
//        List<Project> projects = projectService.findAllByUser(currentUser);

        List<Project> projects = projectService.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    //check if this project belogs to user
    @GetMapping("/getProject")
    public ResponseEntity<?> getProject(@RequestParam(name = "projectName") String projectName)  {
        Project project = projectService.findByProjectName(projectName);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("/createProject")
    public ResponseEntity<?> createProject(
//            Principal principal,
            @RequestParam(name = "projectName") String projectName) {
//        User currentUser = getCurrentUser(principal);
//        Project project = new Project();
     //   project.setId(project.getId());
//        project.setProjectName(projectName);
        Project project = projectService.createProjectByProjectName(projectName);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

//    addProject(Project project)

    @DeleteMapping ("/deleteProjectById")
    public ResponseEntity<?> deleteProjectById(
//            Principal principal,
            @RequestParam(name = "projectId") Long projectId) {
//        User currentUser = getCurrentUser(principal);
        projectService.deleteProjectByProjectId(projectId);
        String message = "A project with id: " + projectId + " has been deleted.";
        return new ResponseEntity<>(message, HttpStatus.OK);//cant be null
    }

    @DeleteMapping("/deleteProject")
    public ResponseEntity<?> deleteProject(
//            Principal principal,
            @RequestParam(name = "projectName") String projectName) {
//        User currentUser = getCurrentUser(principal);
        projectService.deleteProjectByProjectName(projectName);
        String message = "A project with id: " + projectName + " has been deleted.";
        return new ResponseEntity<>(message, HttpStatus.OK);//cant be null
    }

    @DeleteMapping("/deleteAllProject")
    public ResponseEntity<?> deleteAllProjects(
//            Principal principal,
            @RequestParam(name = "userName") String userName) {
//        User currentUser = getCurrentUser(principal);
//        List<Project> projects = projectService.deleteAllProject(currentUser);
        User user = userService.findByUsername(userName);
        List<Project> projects = projectService.deleteAllByUser(user);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/updateProject")
    public ResponseEntity<?> updateProject(
//            Principal principal,
            @RequestParam(name = "projectNameOld") String projectNameOld,
            @RequestParam(name = "projectNameNew") String projectNameNew) {
//        User currentUser = getCurrentUser(principal);

        Project project = projectService.updateProject(projectNameOld, projectNameNew);
        if (project == null) {
            String message = "There is no project with the name " + projectNameOld;
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

//    @PostMapping("/addProductToProject")
//    public ResponseEntity<?> addProductToProject(@RequestBody Project project, @RequestBody Product product) {
//        ProjectProduct projectProduct = projectProductService.addProductToProject(project, product);
//        return new ResponseEntity<>(projectProduct, HttpStatus.OK);
//    }

//    @DeleteMapping("/deleteProductFromProject")
//    public ResponseEntity<?> deleteProductFromProject(@RequestBody Project project, @RequestBody Product product) {
//        ProjectProduct projectProduct = projectProductService.deleteByProductIdAndProjectId(product.getId(), project.getId());
//        return new ResponseEntity<>(projectProduct, HttpStatus.OK);
//    }

    @PostMapping("/addProductToProject")
    public ResponseEntity<?> addProductToProject(
//            Principal principal,
             @RequestParam(name = "projectId") String projectId,    //maybe change to projectName?
             @RequestParam(name = "productId") String productId) {  //maybe change to productName?
        //check first before adding, if ProjectProduct exist => do nothing, otherwise add it.
        ProjectProduct projectProduct = projectProductService.addProductToProject(
                projectService.findByProjectId(Long.valueOf(projectId)), productService.findByProductId(Long.valueOf(productId)));
        return new ResponseEntity<>(projectProduct, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductFromProject")
    @Transactional
    public ResponseEntity<?> deleteProductFromProject(
            //            Principal principal,
            @RequestParam(name = "projectId") String projectId,     //maybe change to projectName?
            @RequestParam(name = "productId") String productId) {   //maybe change to productName?
        projectProductService.deleteByProductIdAndProjectId(Long.valueOf(productId), Long.valueOf(projectId));
        String message = "The product with id: " + productId + " has been deleted " + "from project with id: " + projectId;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //should be with username instead of id
    @GetMapping("/getAllProductByProjectId")
    public  List<Product> getAllProductByProjectId(@RequestParam(name = "projectId") Long projectId) {
        return projectProductService.findAllProductByProjectId(projectId);
    }

    //should be with username instead of id
    @GetMapping("/getAllProjectByProductId")
    public List<Project> getAllProjectByProductId(@RequestParam(name = "productId") Long productId) {
        return projectProductService.findAllProjectByProductId(productId);
    }
}
