package com.movieproject.movieproject.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@Data
public class Movie {

    @Id
    Long id;
    String movie_name;
    String director;
    Integer imdb_number;
    String image;
}
