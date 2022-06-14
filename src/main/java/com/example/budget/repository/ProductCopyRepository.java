package com.example.budget.repository;

import com.example.budget.model.ProductCopy;
import com.example.budget.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCopyRepository extends JpaRepository<ProductCopy, Long> {
    public Long countById(Long id);

    public void deleteProductCopiesByProjectId (Long id);
}
