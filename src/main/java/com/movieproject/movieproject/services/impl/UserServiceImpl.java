package com.movieproject.movieproject.services.impl;

import com.movieproject.movieproject.entity.User;
import com.movieproject.movieproject.exceptions.UserNotFoundException;
import com.movieproject.movieproject.repos.UserRepository;
import com.movieproject.movieproject.services.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else
            return null;
    }
    @Override
    public void deleteById(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
            throw new UserNotFoundException("user does not exist!");
        }

    }
}
