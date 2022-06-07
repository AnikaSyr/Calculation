package com.example.budget.repository;

import com.example.budget.model.Project;
import com.example.budget.model.ProjectsProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectProductsRepository extends JpaRepository<ProjectsProducts, Long> {
    public List<ProjectsProducts> findByProject(Project project);
}
