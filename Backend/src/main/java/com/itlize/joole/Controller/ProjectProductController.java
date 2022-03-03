package com.itlize.joole.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projectProducts")
public class ProjectProductController {

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

    //getProjectProduct(projectId)
    //getProjectProduct(proctId

    //getAllProduct(projectId)
    //getAllProject(productId)


}
