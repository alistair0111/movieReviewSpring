package com.movieratings.movie.controller;


import com.movieratings.movie.domain.Movie;
import com.movieratings.movie.domain.Review;
import com.movieratings.movie.service.MovieService;
import com.movieratings.movie.service.ReviewService;
import com.movieratings.movie.service.request.ReviewRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    ReviewService reviewService;

    @Autowired
    MovieService movieService;

    static String NO_MOVIE = "No Movie Found";
    static String NO_REVIEW = "No Reviews Found";

    //route to add movie reviews (user privileges)
    @PostMapping("/review/add")
    public ResponseEntity<Review> addReview(@RequestBody ReviewRequest reviewRequest){
        return new ResponseEntity<>(reviewService.addReview(reviewRequest.toReview()),
                HttpStatus.CREATED);
    }

    //route to find movie reviews by Id (user privileges)
    @GetMapping("/review/find")
    public ResponseEntity<Object> getReview(@RequestParam Long reviewId){
        Review review = reviewService.getReviewById(reviewId);
        return review==null?
            new ResponseEntity<>("The movie with Id: "+reviewId+" Does not exist.",HttpStatus.NOT_FOUND ):
            new ResponseEntity<>(review.toReviewGetResponse(),HttpStatus.OK );
    }


    //route to search movie by title (user privileges)
    @GetMapping("/find")
    public ResponseEntity<Object> getMovie(@RequestParam String movieName ){
        List<Movie> movie = movieService.findMovie(movieName);
        return new ResponseEntity<>(movie==null?NO_MOVIE:movie, HttpStatus.OK);
    }

    //route to search movie by ratings (user privileges)
    @GetMapping("/findbyrating")
    public ResponseEntity<Object> getMovieByRating(@RequestParam double rating ){
        List<Object> movies = movieService.findMovieByRating(rating);
        return new ResponseEntity<>(movies==null?NO_MOVIE:movies, HttpStatus.OK);
    }

    //find reviews by movieId  (user privileges)
    @GetMapping("/reviewsbymovieid")
    public ResponseEntity<Object> getReviewsByMovieId(@RequestParam long id){
        List<Review> movies = reviewService.getReviewsByMovieId(id);
        return new ResponseEntity<>(movies==null?NO_REVIEW:movies, HttpStatus.OK);
    }

    //find reviews by userid  (user privileges)
    @GetMapping("/reviewsbyuserid")
    public ResponseEntity<Object> getReviewsByUserId(@RequestParam int id){
        List<Object> movies = reviewService.getReviewsByUserId(id);
        return new ResponseEntity<>(movies==null?NO_REVIEW:movies, HttpStatus.OK);
    }

}
