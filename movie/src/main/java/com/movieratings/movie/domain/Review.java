package com.movieratings.movie.domain;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="review_table")
public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId; //reviewid     mysql= -> int

    private String movieReview;   // mysql -> varchar

    private double rating;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedDate;




}
