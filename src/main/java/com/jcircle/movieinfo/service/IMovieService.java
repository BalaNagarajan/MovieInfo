package com.jcircle.movieinfo.service;

import com.jcircle.movieinfo.model.Movie;
import com.jcircle.movieinfo.request.MovieRequest;

import java.util.List;

public interface IMovieService {

    List<Movie> getMoviestInfo(MovieRequest movieRequest);


}
