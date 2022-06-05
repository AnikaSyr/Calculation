package com.example.budget.controller;

import com.example.budget.exception.ClientNotFoundException;
import com.example.budget.exception.DepartmentNotFoundException;
import com.example.budget.model.Client;
import com.example.budget.model.Department;
import com.example.budget.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "department";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String handle(@Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("incorrect data");
            return "department";
        }
        departmentService.save(department);

        return "redirect:/department/find";
    }
    @GetMapping(value = "/find")
    public String getAll(Model model){
        List<Department> departments = departmentService.listAllOrderById();
        model.addAttribute("departments", departments);
        return "departments";}

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {

        try {
            Department department = departmentService.get(id);
            model.addAttribute("department", department);
            return "department_edit";
        } catch (DepartmentNotFoundException e) {
            return "redirect:/department/find";
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {

        try {
            departmentService.delete(id);

        } catch (DepartmentNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/department/find";

    }
}
