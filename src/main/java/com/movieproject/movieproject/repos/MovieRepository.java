package com.movieproject.movieproject.repos;

import com.movieproject.movieproject.entity.Movie;
import com.movieproject.movieproject.response.MovieResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
