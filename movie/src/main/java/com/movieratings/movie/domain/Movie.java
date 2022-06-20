package com.movieratings.movie.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieratings.movie.service.response.MovieResponse;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;


    @OneToMany(
            mappedBy = "movie1",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<GenreTable> genres;

    private Double rating;

    private String adminName;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<Review> reviewList;

    public MovieResponse toMovieResponse(){
        return MovieResponse.builder().genres(this.genres).title(this.title).rating(this.rating).build();
    }

}
