package com.example.budget.controller;

import com.example.budget.exception.ProductNotFoundException;
import com.example.budget.model.Department;
import com.example.budget.model.Product;
import com.example.budget.model.Unit;
import com.example.budget.service.DepartmentService;
import com.example.budget.service.ProductService;
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
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;
    private final DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService, DepartmentService departmentService) {
        this.productService = productService;

        this.departmentService = departmentService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProduct (Model model){
        List<Unit> units = Arrays.asList(Unit.values());
        List<Department> departments = departmentService.listAll();

        model.addAttribute("product", new Product());
        model.addAttribute("units", units);
        model.addAttribute("departments", departments);
        return "product";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String handle (@Valid Product product, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors()){
            logger.error("incorrect data");
            return "product";
        }
        productService.save(product);
        ra.addFlashAttribute("message", "The product has been saved successfully");

        return "redirect:/product/find";
    }

    @GetMapping(value = "/find")
    public String getAll(Model model){
        List<Product> products = productService.listAllOrderById();
        model.addAttribute("products", products);
        return "products";}

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {

        List<Department> departments = departmentService.listAll();
        try {
            Product product = productService.get(id);
            model.addAttribute("product", product);
            model.addAttribute("departments", departments);
            return "product_edit";
        } catch (ProductNotFoundException e) {
            return "redirect:/product/find";
        }

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {

        try {
            productService.delete(id);

        } catch (ProductNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/product/find";

    }


}
