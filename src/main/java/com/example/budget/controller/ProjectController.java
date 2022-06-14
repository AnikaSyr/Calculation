package com.example.budget.controller;

import com.example.budget.exception.ProjectNotFoundException;
import com.example.budget.model.*;
import com.example.budget.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    private final ProductCopyService productCopyService;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProjectController(ProjectService projectService, ClientService clientService, ProductService productService, DepartmentService departmentService, ProductCopyService productCopyService) {
        this.projectService = projectService;
        this.clientService = clientService;
        this.productService = productService;
        this.departmentService = departmentService;
        this.productCopyService = productCopyService;
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
    public String handle (@Valid Project project,@RequestParam List<Integer> params, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors()){
            logger.error("incorrect data");
            return "project";
        }
        List<Product> products = project.getProducts();


        projectService.save(project);
        Long id = project.getId();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            ProductCopy productCopy = new ProductCopy();
            productCopy.setName(product.getName());
            productCopy.setProject(project);
            productCopy.setDepartment(product.getDepartment());
            productCopy.setPrice(product.getPrice());
            productCopy.setUnit(product.getUnit());
            productCopy.setAmount(params.get(i));

            productCopyService.save(productCopy);
        }
        ra.addFlashAttribute("message", "The project has been saved successfully");

        return "redirect:/project/find/" + id;
}
//    @RequestMapping(value = "/change", method = RequestMethod.POST)
//    public String change (@Valid Project project, @RequestParam List<Long> id, @RequestParam List<Integer> params, BindingResult bindingResult, RedirectAttributes ra){
//        if(bindingResult.hasErrors()){
//            logger.error("incorrect data");
//            return "project_edit";
//        }
//
//
//        List<ProductCopy> products = project.getProductsCopies();
//        projectService.save(project);
//        for (int i = 0; i < products.size(); i++) {
//            ProductCopy productCopy = products.get(i);
//            productCopy.setId(id.get(i));
//            productCopy.setProject(project);
//            productCopy.setAmount(params.get(i));
//        productCopyService.save(productCopy);}
//
//        ra.addFlashAttribute("message", "The project has been saved successfully");
//
//        return "redirect:/project/find/";
//    }
@GetMapping("find/{id}")
public String ShowOne(@PathVariable("id") Long id, Model model, RedirectAttributes ra){

    try {
        Project project = projectService.get(id);
        model.addAttribute("project", project);
        return "project_one";
    } catch (ProjectNotFoundException e) {
        ra.addFlashAttribute("message", e.getMessage());
        return "redirect:/project/find";
    }

}

    @GetMapping(value = "/find")
    public String getAll(Model model){
        List<Project> projects = projectService.listAllOrderById();
        model.addAttribute("projects", projects);
        return "projects";}

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {

        Collection<Client>clients = clientService.listAll();
        List<Department> departments = departmentService.listAll();
        try {
            Project project = projectService.get(id);
            model.addAttribute("project", project);
            model.addAttribute("clients", clients);
            model.addAttribute("departments", departments);
            return "project_edit";
        } catch (ProjectNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/project/find";
        }

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {

        try {
            projectService.delete(id);

        } catch (ProjectNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/project/find";

    }
}
