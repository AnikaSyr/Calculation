package com.example.budget.controller;

import com.example.budget.model.User;
import com.example.budget.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }

}
