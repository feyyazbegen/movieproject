package com.movieproject.movieproject.controller;

import com.movieproject.movieproject.response.MovieResponse;
import com.movieproject.movieproject.services.MovieService;
import com.movieproject.movieproject.services.OMDBApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private OMDBApiServiceImpl apiService;
    private MovieService movieService;


    @GetMapping("/movies")
    public ResponseEntity<Void> getMovies(@RequestParam String title) {
        apiService.getAllMovie(title);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/movies/{movieId}")
    public MovieResponse getOneMovie(@PathVariable Long movieID) {
        return movieService.getOneMovie(movieID);
    }
}
