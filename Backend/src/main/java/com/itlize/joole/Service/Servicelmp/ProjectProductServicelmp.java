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
        ProjectProduct projectProduct = projectProductRepository.findAllByProductAndProject(product, project);
        if(projectProduct != null){
            return projectProduct;
        }
        ProjectProduct projectProduct1 = new ProjectProduct();
        projectProduct1.setProduct(product);
        projectProduct1.setProject(project);
        return createProjectProduct(projectProduct1);
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
    public ProjectProduct deleteByProductIdAndProjectId(Long productId, Long projectId) {
        ProjectProduct projectProduct = projectProductRepository.findAllByProductIdAndProjectId(productId, projectId);
        if(projectProduct == null){
            return projectProduct;
        }
        return  projectProductRepository.deleteByProductIdAndProjectId(productId, projectId);
    }

    @Override
    public List<ProjectProduct> findByProjectId(Long projectId) {
        return projectProductRepository.findAllByProjectId(projectId).orElse(null);
    }

    @Override
    public List<ProjectProduct> findByProductId(Long productId) {
        return projectProductRepository.findAllByProductId(productId).orElse(null);
    }

    @Override
    public List<Product> findAllProductByProjectId(Long projectId) {
        List<Product> products = new ArrayList<>();
        List<ProjectProduct> projectProducts = projectProductRepository.findAllByProjectId(projectId).orElse(null);
        if(projectProducts == null){
            return null;
        }
        for (ProjectProduct projectProduct : projectProducts) {
            products.add(projectProduct.getProduct());
        }
        return products;
    }

    @Override
    public List<Project> findAllProjectByProductId(Long productId, String userName) {
        List<Project> projects = new ArrayList<>();
        List<ProjectProduct> projectProducts = projectProductRepository.findAllByProductId(productId).orElse(null);
        if(projectProducts == null){
            return null;
        }
        for (ProjectProduct projectProduct : projectProducts) {
            Project project = projectProduct.getProject();
            if(project.getUser().getUsername().equals(userName)){
                projects.add(project);
            }
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
