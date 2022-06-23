package com.movieratings.movie.repositories;


import com.movieratings.movie.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Transactional
    void deleteByMovieMovieId(long movieId);

    List<Review> findByMovieMovieId(long id);

    @Query(value = "select review_id, created_date, movie_review, rating, updated_date from review_table where user_user_id=:id", nativeQuery = true)
    List<Object> findByUserUserId(int id);
}
