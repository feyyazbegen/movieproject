package com.movieproject.movieproject.converter;

import com.movieproject.movieproject.entity.Role;
import com.movieproject.movieproject.entity.User;
import com.movieproject.movieproject.request.CreateUserRequest;
import com.movieproject.movieproject.request.UpdateUserRequest;
import com.movieproject.movieproject.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component //
public class UserConverter {

    public User convertToUser(CreateUserRequest request) {
        User response = new User();
        response.setUsername(request.getUserName());
        response.setPassword(request.getPassword());
        Role role = new Role();
        role.setName("ROLE_USER");
        response.setRoles(Collections.singleton(role));
        return response;
    }

    public UserResponse convertToUserResponse(User user){
        UserResponse userResponse = new UserResponse(user);
        return userResponse;
    }

    public User convertToUser(UpdateUserRequest request){
        User response = new User();
        response.setUsername(request.getUserName());
        response.setPassword(request.getPassword());
        return response;
    }

}
