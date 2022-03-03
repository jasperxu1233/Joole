package com.itlize.joole.Repository;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Long> {
    void deleteByProductIdAndProjectId(Long productId, Long projectId);

    Optional<List<ProjectProduct>> findByProjectId(Long projectId);

    Optional<List<ProjectProduct>> findByProductId(Long productId);
}
