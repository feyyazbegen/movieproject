package com.movieproject.movieproject.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String userName;
    private String password;
}
