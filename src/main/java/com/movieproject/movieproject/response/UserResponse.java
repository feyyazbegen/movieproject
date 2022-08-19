package com.movieproject.movieproject.response;

import com.movieproject.movieproject.entity.User;
import com.movieproject.movieproject.repos.UserRepository;
import com.movieproject.movieproject.services.UserService;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String rolename;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.rolename = String.valueOf(entity.getRoles());
    }

}
