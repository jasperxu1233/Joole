package com.itlize.joole.Service;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.ProjectProduct;
import com.itlize.joole.Entity.User;

import java.util.List;

public interface ProjectProductService {

    ProjectProduct createProjectProduct(ProjectProduct projectProduct);

    ProjectProduct addProductToProject(Project project, Product product);

//    ProjectProduct addProductToProjectUsingId(Long productId, Long projectId);

    ProjectProduct findById(Long projectProductId);

    ProjectProduct deleteByProductIdAndProjectId(Long productId, Long projectId);

    List<ProjectProduct> findByProjectId(Long projectId);

    List<ProjectProduct> findByProductId(Long productId);

    List<Product> findAllProductByProjectId(Long projectId);

    List<Project> findAllProjectByProductId(Long productId, String userName);

//    //new
//    void deleteByProduct(Product product);
//
//    //new
//    void deleteByProject(Project project);
}
