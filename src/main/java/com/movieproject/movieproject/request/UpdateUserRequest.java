package com.movieproject.movieproject.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateUserRequest {
    @JsonProperty("username")
    private String userName;
    private String password;
}
