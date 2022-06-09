package com.example.budget.controller;

import com.example.budget.model.*;
import com.example.budget.service.ClientService;
import com.example.budget.service.DepartmentService;
import com.example.budget.service.ProductService;
import com.example.budget.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("productCopy", new ProductCopy());

        return "project";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String handle (@Valid Project project, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors()){
            logger.error("incorrect data");
            return "project";
        }
        projectService.save(project);
        ra.addFlashAttribute("message", "The project has been saved successfully");

        return "redirect:/project/find";
}
}
