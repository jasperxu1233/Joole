package com.itlize.joole.Service.Servicelmp;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.ProjectProduct;
import com.itlize.joole.Repository.ProjectProductRepository;
import com.itlize.joole.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectProductServicelmp implements ProjectProductService {
    @Autowired
    ProjectProductRepository projectProductRepository;

    @Override
    public ProjectProduct createProjectProduct(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }

    @Override
    public ProjectProduct addProductToProject(Project project, Product product) {
        ProjectProduct projectProduct = new ProjectProduct();
        projectProduct.setProduct(product);
        projectProduct.setProject(project);
        createProjectProduct(projectProduct);
        return projectProduct;
    }

//    @Override
//    public ProjectProduct addProductToProjectUsingId(Long productId, Long projectId) {
//        ProjectProduct projectProduct = new ProjectProduct();
//        projectProduct.setProduct(productService.);
//        projectProduct.setProject(project);
//        createProjectProduct(projectProduct);
//        return projectProduct;
//    }

    @Override
    public ProjectProduct findById(Long projectProductId) {
        return projectProductRepository.findById(projectProductId).orElse(null);
    }

    @Override
    @Transactional
    public void deleteByProductIdAndProjectId(Long productId, Long projectId) {
        projectProductRepository.deleteByProductIdAndProjectId(productId, projectId);
    }

    @Override
    public List<ProjectProduct> findByProjectId(Long projectId) {
        return projectProductRepository.findByProjectId(projectId).orElse(null);
    }

    @Override
    public List<ProjectProduct> findByProductId(Long productId) {
        return projectProductRepository.findByProductId(productId).orElse(null);
    }

    @Override
    public List<Product> findAllProductByProjectId(Long projectId) {
        List<Product> products = new ArrayList<>();
        List<ProjectProduct> projectProducts = projectProductRepository.findByProjectId(projectId).orElse(null);
        if(projectProducts == null){
            return null;
        }
        for (ProjectProduct projectProduct : projectProducts) {
            products.add(projectProduct.getProduct());
        }
        return products;
    }

    @Override
    public List<Project> findAllProjectByProductId(Long productId) {
        List<Project> projects = new ArrayList<>();
        List<ProjectProduct> projectProducts = projectProductRepository.findByProductId(productId).orElse(null);
        if(projectProducts == null){
            return null;
        }
        for (ProjectProduct projectProduct : projectProducts) {
            projects.add(projectProduct.getProject());
        }
        return projects;
    }

//    @Override
//    public void deleteByProduct(Product product) {
//        projectProductRepository.deleteByProduct(product);
//    }
//
//    @Override
//    public void deleteByProject(Project project) {
//        projectProductRepository.deleteByProject(project);
//    }


}
