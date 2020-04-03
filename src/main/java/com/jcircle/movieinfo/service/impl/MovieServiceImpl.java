package com.jcircle.movieinfo.service.impl;

import com.jcircle.movieinfo.model.Movie;
import com.jcircle.movieinfo.request.MovieRequest;
import com.jcircle.movieinfo.service.IMovieService;
import com.jcircle.movieinfo.utils.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "movieService")
public class MovieServiceImpl implements IMovieService {

    @Override
    public List<Movie> getMoviestInfo(MovieRequest movieRequest) {

        List<Movie> movieList = this.populateMovies();
        List<Movie> updatesList = new ArrayList<Movie>(movieList.size());

        movieList.stream().forEach(movieObj -> {
            //Checking the first name
            if (CommonUtils.isNotEmpty(movieRequest.getMovieName()) && movieRequest.getMovieName().equalsIgnoreCase(movieObj.getMovieName())) {
                updatesList.add(movieObj);
            }

            //Check the artist id in the given list
            if (CommonUtils.isNotEmpty(movieRequest.getMovieIdList())) {
                if (movieRequest.getMovieIdList().contains(movieObj.getMovieId())) {
                    updatesList.add(movieObj);
                }
            }
        });

        return updatesList;
    }

    public List<Movie> populateMovies() {

        List<Movie> movieList = new ArrayList<>();
        Movie movieObj = new Movie();

        movieObj.setMovieId("1");
        movieObj.setImdbRating(7.0);
        movieObj.setMovieName("Speed");
        movieObj.setYear(1990);
        movieList.add(movieObj);
        //Record 2

        movieObj = new Movie();
        movieObj.setMovieId("2");
        movieObj.setImdbRating(8.0);
        movieObj.setMovieName("Darbar");
        movieObj.setYear(1990);
        movieList.add(movieObj);

        return movieList;

    }

}
