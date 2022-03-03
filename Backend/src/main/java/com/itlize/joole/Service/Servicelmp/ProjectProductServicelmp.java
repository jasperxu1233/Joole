package com.itlize.joole.Service.Servicelmp;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.ProjectProduct;
import com.itlize.joole.Repository.ProjectProductRepository;
import com.itlize.joole.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectProductServicelmp implements ProjectProductService {
    @Autowired
    ProjectProductRepository projectProductRepository;

    @Override
    public ProjectProduct createProjectProduct(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }

    @Override
    public ProjectProduct findById(Long projectProductId) {
        return projectProductRepository.findById(projectProductId).orElse(null);
    }

    @Override
    public void deleteByProductIdAndProjectId(Long productId, Long projectId) {
        projectProductRepository.deleteByProductIdAndProjectId(productId, projectId);
    }

    @Override
    public Optional<List<ProjectProduct>> findByProjectId(Long projectId) {
        return projectProductRepository.findByProjectId(projectId);
    }
}
