package com.example.api.controllers;

import com.example.api.models.UserModel;
import com.example.api.repositories.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
  @Autowired private UserRepository userRepository;

  @GetMapping("/users")
  @ResponseBody
  public List<UserModel> getUsers(@RequestParam(required = false) Long id,
                                  @RequestParam(required = false) String name) {
    List<UserModel> users;
    Optional<UserModel> usersOptional;

    if (id != null && name != null) {
      return Collections.emptyList();
    }

    if (id != null) {
      usersOptional = userRepository.findById(id);
      users = usersOptional.map(Collections::singletonList)
                  .orElse(Collections.emptyList());
      // System.out.println(usersOptional);
      return users;
    }

    if (name != null) {
      users = userRepository.findByName(name);

      System.out.println(users);
      return users;
    }

    users = userRepository.findAll();
    return users;

    // System.out.println(users);
  }
}
