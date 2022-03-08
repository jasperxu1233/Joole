package com.itlize.joole.Service;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.ProjectProduct;

import java.util.List;
import java.util.Optional;

public interface ProjectProductService {

    ProjectProduct createProjectProduct(ProjectProduct projectProduct);

    ProjectProduct findById(Long projectProductId);

    void deleteByProductIdAndProjectId(Long productId, Long projectId);

    List<ProjectProduct> findByProjectId(Long projectId);

    List<ProjectProduct> findByProductId(Long productId);

//    //new
//    void deleteByProduct(Product product);
//
//    //new
//    void deleteByProject(Project project);
}
