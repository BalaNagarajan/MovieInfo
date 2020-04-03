package com.jcircle.movieinfo.controller;

import com.jcircle.movieinfo.model.Movie;
import com.jcircle.movieinfo.request.MovieRequest;
import com.jcircle.movieinfo.response.BaseResponse;
import com.jcircle.movieinfo.response.MovieResponse;
import com.jcircle.movieinfo.service.IMovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MovieController {

    @Autowired
    IMovieService movieService;


    @CrossOrigin
    @PostMapping(value = "/v1/movies/info")
    @ApiOperation(value = "Get Movie Information",
        notes = "Choose the appropriate request parameters.")
    public ResponseEntity<BaseResponse> getMovieInfo(@ApiParam(value = " {\n"
        + "  \"movieName\": \"Batman\",\n"
        + "  \"movieIdList\": \"[100]\"\n"
        + "}")@RequestBody MovieRequest movieRequest) {

        System.out.println(movieRequest.getMovieName());


        ResponseEntity<BaseResponse> responseEntityObj = null;

        List<Movie> movieList = movieService.getMoviestInfo(movieRequest);

        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovieList(movieList);
        responseEntityObj = new ResponseEntity(movieResponse, HttpStatus.OK);

        return responseEntityObj;
    }

}
