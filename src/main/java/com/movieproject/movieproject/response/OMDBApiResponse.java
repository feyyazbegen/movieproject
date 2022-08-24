package com.movieproject.movieproject.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OMDBApiResponse {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private Integer year;
    private String imdbID;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Poster")
    private String poster;

}
