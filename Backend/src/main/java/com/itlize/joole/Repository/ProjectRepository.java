package com.itlize.joole.Repository;

import com.itlize.joole.Entity.Project;
import com.itlize.joole.Entity.User;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<List<Project>> findAllByUser (User user);

    void deleteProjectById(Long id);


}
