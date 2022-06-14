//package com.example.budget.service;
//
//import com.example.budget.model.Project;
//import com.example.budget.model.ProjectsProducts;
//import com.example.budget.repository.ProjectProductsRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProjectProductsService {
//    private final ProjectProductsRepository projectProductsRepository;
//
//    public ProjectProductsService(ProjectProductsRepository projectProductsRepository) {
//        this.projectProductsRepository = projectProductsRepository;
//    }
//
//    public List<ProjectsProducts> listProductsByProject (Project project) {
//        return projectProductsRepository.findByProject(project);
//    }
//}
