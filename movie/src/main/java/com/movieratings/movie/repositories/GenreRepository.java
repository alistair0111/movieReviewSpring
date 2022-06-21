package com.movieratings.movie.repositories;

import com.movieratings.movie.domain.GenreTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreTable,Long> {

//    @Query(value = "select * from movie_table order by rating", nativeQuery = true)
//    public List<Movie> orderByRatingGroupByTitle();
}
