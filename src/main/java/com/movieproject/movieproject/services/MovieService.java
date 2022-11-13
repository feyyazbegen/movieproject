package com.movieproject.movieproject.services;

import com.movieproject.movieproject.entity.Movie;
import com.movieproject.movieproject.repos.MovieRepository;
import com.movieproject.movieproject.response.MovieResponse;
import com.movieproject.movieproject.response.OMDBApiResponse;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    MovieRepository movieRepository;
    private final OMDBApiService omdbApiService;

    public MovieService(OMDBApiService omdbApiService) {
        this.omdbApiService = omdbApiService;
    }

    public void saveMovie(String title){
        OMDBApiResponse allMovie = omdbApiService.getAllMovie(title);
    }

    public Movie getOneMovie(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }
}
