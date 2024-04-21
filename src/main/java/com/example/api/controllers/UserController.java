package com.example.api.controllers;

import com.example.api.models.UserModel;
import com.example.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users") @ResponseBody
    public List<UserModel> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        System.out.println(users);
        return users;
    }


}
