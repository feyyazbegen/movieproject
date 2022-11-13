package com.movieproject.movieproject.response;

import com.movieproject.movieproject.entity.User;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
    }

}
