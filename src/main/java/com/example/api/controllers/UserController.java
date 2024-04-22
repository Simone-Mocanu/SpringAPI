package com.example.api.controllers;

import com.example.api.models.UserModel;
import com.example.api.repositories.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
  public List<UserModel>
  getUsers(@RequestParam(required = false) Map<String, String> params) {

    List<UserModel> users;
    Optional<UserModel> usersOptional;

    if (params.size() == 0) {
      users = userRepository.findAll();
      // System.out.println(users);
      return users;
    }

    if (params.size() > 1) {
      return Collections.emptyList();
    }

    String key = params.keySet().iterator().next();
    String value = params.get(key);

    if (key.equals("name")) {
      users = userRepository.findByName(value);

      System.out.println(users);
      return users;
    }

    if (key.equals("surname")) {
      users = userRepository.findBySurname(value);

      System.out.println(users);
      return users;
    }

    if (key.equals("id")) {
      usersOptional = userRepository.findById(Long.valueOf(value));
      users = usersOptional.map(Collections::singletonList)
                  .orElse(Collections.emptyList());
      // System.out.println(usersOptional);
      return users;
    }

    return Collections.emptyList();
  }
}
