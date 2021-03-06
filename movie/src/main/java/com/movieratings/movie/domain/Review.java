package com.movieratings.movie.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movieratings.movie.service.response.ReviewByUserIdResponse;
import com.movieratings.movie.service.response.ReviewGetResponse;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@ToString(exclude = { "movie" })
@NoArgsConstructor
@Table(name="review_table")
@Builder
public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    private String movieReview;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "movie_movie_id", nullable = false)
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_user_id", nullable = false)
    @JsonBackReference
    private Users users;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;


    public ReviewGetResponse toReviewGetResponse(){
        return ReviewGetResponse.builder().movieId(this.movie.getMovieId()).
                review(this).movie(this.movie).build();
    }

    public ReviewByUserIdResponse toReviewByUserIdResponse(){
        return ReviewByUserIdResponse.builder().reviewId(reviewId)
                .createdDate(createdDate)
                .updatedDate(updatedDate)
                .rating(rating)
                .movieReview(movieReview)
                .build();
    }
    
}
