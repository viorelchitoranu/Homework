package com.devmind.springapp.rest_demo.controllers;


import com.devmind.springapp.rest_demo.dtos.User;
import com.devmind.springapp.rest_demo.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    //@Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Optional<User> newUser = userService.createUser(user);

        return newUser.isPresent()
                ? ResponseEntity.status(HttpStatus.CREATED).body(newUser.get())
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
    }


}
