package com.movieproject.movieproject.services;

import com.movieproject.movieproject.entity.User;

import java.util.List;

public interface UserService {
    public abstract List<User> getAllUsers();
    User saveOneUser(User newUser);
    User getOneUser(Long userId);
    User updateOneUser(Long userId, User newUser);
    void deleteById(Long userId);

}
