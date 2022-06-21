package com.movieratings.movie.service;


import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> findMovie(String movieName){
        return movieRepository.findByTitleContaining(movieName);
    }

    public List<Object> findMovieByRating(double rating){
        return movieRepository.findByRatingGreaterThanEqual(rating);
    }
}
