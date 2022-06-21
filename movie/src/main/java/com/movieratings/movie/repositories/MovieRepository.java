package com.movieratings.movie.repositories;


import com.movieratings.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    //find by title
    List<Movie> findByTitleContaining(String movieName);

    //find by rating
    //@Query(value = "select * from movie_table where rating > :rating order by genre", nativeQuery = true)
    List<Object> findByRatingGreaterThanEqual(double rating);

    //delete by id
    void deleteById(long movieId);
}
