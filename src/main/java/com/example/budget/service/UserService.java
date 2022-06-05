package com.example.budget.service;

import com.example.budget.model.User;



public interface UserService {
    User findByUserName (String userName);
    void saveUser (User user);
}
