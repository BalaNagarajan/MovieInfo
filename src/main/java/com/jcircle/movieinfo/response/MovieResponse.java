package com.jcircle.movieinfo.response;

import com.jcircle.movieinfo.model.Movie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class MovieResponse extends BaseResponse {

    private List<Movie> movieList;

}
