package com.movieratings.movie.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movieratings.movie.service.response.ReviewResponse;
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

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    public ReviewResponse toReviewResponse(){
        return ReviewResponse.builder().movieId(this.movie.getMovieId()).
                review(this).build();
    }

}
