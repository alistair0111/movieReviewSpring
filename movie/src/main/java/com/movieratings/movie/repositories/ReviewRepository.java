package com.movieratings.movie.repositories;


import com.movieratings.movie.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Transactional
    void deleteByMovieMovieId(long movieId);
}
