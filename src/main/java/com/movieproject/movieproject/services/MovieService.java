package com.movieproject.movieproject.services;

import com.movieproject.movieproject.entity.Movie;

public interface MovieService {

    void saveMovie(String title);
    Movie getOneMovie(Long movieId);

}
