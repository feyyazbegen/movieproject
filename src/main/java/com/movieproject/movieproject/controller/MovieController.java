package com.movieproject.movieproject.controller;

import com.movieproject.movieproject.entity.Movie;
import com.movieproject.movieproject.response.MovieResponse;
import com.movieproject.movieproject.services.MovieService;
import com.movieproject.movieproject.services.OMDBApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private OMDBApiServiceImpl apiService;
    private MovieService movieService;


    @GetMapping()
    public ResponseEntity<Void> getMovies(@RequestParam String title) {
        apiService.getAllMovie(title);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{movieId}")
    public MovieResponse getOneMovie(@PathVariable Long movieId) {
        Movie movie = movieService.getOneMovie(movieId);
        if(movie == null){
            return null;
        }
        return new MovieResponse(movie);

    }
}
