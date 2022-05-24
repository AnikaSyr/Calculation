package com.example.budget.service;

import com.example.budget.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User findByUserName (String userName);
    void saveUser (User user);
}
