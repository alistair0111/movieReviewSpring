package com.movieratings.movie.service.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReviewByUserIdResponse {
    private long reviewId;

    private Date createdDate;

    private String movieReview;

    private double rating;

    private Date updatedDate;

}
