package com.movieratings.movie.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="genre_table")
@Builder
public class GenreTable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreId;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "movie_movie_id")
    @JsonBackReference
    private Movie movie1;
}
