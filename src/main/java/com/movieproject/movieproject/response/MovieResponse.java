package com.movieproject.movieproject.response;

import lombok.Data;

@Data
public class MovieResponse {

    Long id;
    String movie_name;
    String director;
    Integer imdb_number;
    String image;
}
