package com.movieproject.movieproject.controller;


import com.movieproject.movieproject.entity.User;
import com.movieproject.movieproject.response.UserResponse;
import com.movieproject.movieproject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers().stream().map(u -> new UserResponse(u)).toList();
    }

    @PostMapping
    public User createuser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }
}
