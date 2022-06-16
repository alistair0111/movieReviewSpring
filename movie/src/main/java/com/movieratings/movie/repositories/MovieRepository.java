package com.movieratings.movie.repositories;


import com.movieratings.movie.domain.Genre;
import com.movieratings.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {


//    @Query("update movie_table set title = ?2, genre = ?3 where movie_id=?1")
//    Movie updateMovie(Long movieId, String title, Genre genre);
}
