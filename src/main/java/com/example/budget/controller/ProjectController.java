package com.example.budget.controller;

import com.example.budget.model.Client;
import com.example.budget.model.Department;
import com.example.budget.model.Product;
import com.example.budget.model.Project;
import com.example.budget.service.ClientService;
import com.example.budget.service.DepartmentService;
import com.example.budget.service.ProductService;
import com.example.budget.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ClientService clientService;
    private final ProductService productService;
    private final DepartmentService departmentService;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProjectController(ProjectService projectService, ClientService clientService, ProductService productService, DepartmentService departmentService) {
        this.projectService = projectService;
        this.clientService = clientService;
        this.productService = productService;
        this.departmentService = departmentService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProject (Model model){
        Collection<Client> clients = clientService.listAll();
        List<Department> departments = departmentService.listAll();
        List<Product> products = productService.listAll();

        model.addAttribute("project", new Project());
        model.addAttribute("clients", clients);
        model.addAttribute("departments", departments);
        model.addAttribute("products", products);

        return "project";
    }
}
