package com.movieproject.movieproject.controller;


import com.movieproject.movieproject.converter.UserConverter;
import com.movieproject.movieproject.entity.User;
import com.movieproject.movieproject.exceptions.UserNotFoundException;
import com.movieproject.movieproject.request.CreateUserRequest;
import com.movieproject.movieproject.request.UpdateUserRequest;
import com.movieproject.movieproject.response.UserResponse;
import com.movieproject.movieproject.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> result = userService.getAllUsers()
                .stream()
                .map(user -> userConverter.convertToUserResponse(user))
                .toList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest request) {
        User user = userService.saveOneUser(userConverter.convertToUser(request));
        if (user != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getOneUser(@PathVariable Long userId) {
        User user = userService.getOneUser(userId);
        if (user == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( userConverter.convertToUserResponse(user),HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateOneUser(@PathVariable Long userId, @RequestBody UpdateUserRequest request) {
        User user = userService.updateOneUser(userId, userConverter.convertToUser(request));
        UserResponse userResponse = userConverter.convertToUserResponse(user);
        if (user != null)
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleUserNotFound() {

    }

}
