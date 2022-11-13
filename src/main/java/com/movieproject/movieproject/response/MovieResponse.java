package com.movieproject.movieproject.response;

import com.movieproject.movieproject.entity.Movie;
import lombok.Data;

import java.util.Optional;

@Data
public class MovieResponse {

    Long id;
    String movie_name;
    String director;
    Integer imdb_number;
    String image;

    public MovieResponse (Movie entity){
        this.id=entity.getId();
        this.movie_name=entity.getMovie_name();
        this.director= entity.getDirector();
        this.imdb_number= entity.getImdb_number();
        this.image=entity.getImage();
    }

}
