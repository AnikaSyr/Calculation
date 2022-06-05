package com.example.budget.service;

import com.example.budget.exception.ProjectNotFoundException;
import com.example.budget.model.Project;
import com.example.budget.repository.ProjectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public List<Project> listAllOrderById(){
        return (List<Project>) projectRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
    }
    public void save(Project project){
        projectRepository.save(project);
    }

    public Project get(Long id) throws ProjectNotFoundException {
        Optional<Project> result = projectRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ProjectNotFoundException ("Could not find any project with ID " + id);
    }

    public void delete (Long id) throws ProjectNotFoundException {
        Long count = projectRepository.countById(id);
        if(count == null || count ==0) {
            throw new ProjectNotFoundException("Could not find any project with ID " + id);
        }
        projectRepository.deleteById(id);
    }
}
