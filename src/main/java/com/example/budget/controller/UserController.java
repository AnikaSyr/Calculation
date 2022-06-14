package com.example.budget.controller;

import com.example.budget.model.Client;
import com.example.budget.model.User;
import com.example.budget.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
      model.addAttribute("user", new User());
        return "user_register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handle (@Valid User user, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors()){
            logger.error("incorrect data");
            return "user_register";
        }
        userService.saveUser(user);
        ra.addFlashAttribute("message", "The user has been saved successfully");

        return "success";
    }


}
