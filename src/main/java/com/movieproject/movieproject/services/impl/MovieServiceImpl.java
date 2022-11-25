package com.movieproject.movieproject.services.impl;

import com.movieproject.movieproject.entity.Movie;
import com.movieproject.movieproject.repos.MovieRepository;
import com.movieproject.movieproject.response.OMDBApiResponse;
import com.movieproject.movieproject.services.MovieService;
import com.movieproject.movieproject.services.OMDBApiService;
import org.springframework.stereotype.Service;


@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
    private final OMDBApiService omdbApiService;

    public MovieServiceImpl(OMDBApiService omdbApiService) {
        this.omdbApiService = omdbApiService;
    }

    public void saveMovie(String title){
        OMDBApiResponse allMovie = omdbApiService.getAllMovie(title);
    }

    public Movie getOneMovie(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }
}
