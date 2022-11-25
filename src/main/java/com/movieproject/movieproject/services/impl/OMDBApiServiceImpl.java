package com.movieproject.movieproject.services.impl;

import com.movieproject.movieproject.response.OMDBApiResponse;
import com.movieproject.movieproject.services.OMDBApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OMDBApiServiceImpl implements OMDBApiService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public OMDBApiResponse getAllMovie(String title) {
        String baseUrl = "http://www.omdbapi.com/?t=" + title + "&apikey=966aceaa";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<OMDBApiResponse> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, OMDBApiResponse.class);
        return response.getBody();
    }
}
