package com.example.budget.service;

import com.example.budget.exception.ClientNotFoundException;
import com.example.budget.exception.DepartmentNotFoundException;
import com.example.budget.model.Department;
import com.example.budget.repository.DepartmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> listAll(){
        return departmentRepository.findAll();
    }

    public List<Department> listAllOrderById(){
        return (List<Department>) departmentRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
    }
    public void save(Department department){
        departmentRepository.save(department);
    }

    public Department get(Long id) throws DepartmentNotFoundException {
        Optional<Department> result = departmentRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new DepartmentNotFoundException("Could not find any department with ID " + id);
    }
    public void delete (Long id) throws DepartmentNotFoundException {
        Long count = departmentRepository.countById(id);
        if(count == null || count ==0) {
            throw new DepartmentNotFoundException("Could not find any department with ID " + id);
        }
        departmentRepository.deleteById(id);
    }
}
