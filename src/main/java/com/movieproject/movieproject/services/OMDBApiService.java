package com.movieproject.movieproject.services;

import com.movieproject.movieproject.response.OMDBApiResponse;


public interface OMDBApiService {
    public OMDBApiResponse getAllMovie(String title);

}

