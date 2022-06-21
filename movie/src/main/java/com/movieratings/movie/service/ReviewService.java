package com.movieratings.movie.service;

import com.movieratings.movie.domain.Review;
import com.movieratings.movie.repositories.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    ReviewRepository reviewRepository;

    public Review addReview(Review review){
        Review savedReview = reviewRepository.save(review);
        logger.info(String.format("saved the review for movie {0}", savedReview.getMovie().getMovieId()));
        return savedReview;
    }

    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }
}
