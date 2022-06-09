package com.example.budget.repository;

import com.example.budget.model.Department;
import com.example.budget.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Long countById(Long id);
    public Department findByName(String name);

}
