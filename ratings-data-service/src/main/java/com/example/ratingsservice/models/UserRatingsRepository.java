package com.example.ratingsservice.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRatingsRepository extends CrudRepository<UserRating, String> {

    @Query(nativeQuery = true, value = "SELECT movie_id as movieId, SUM(rating) as ratingSum FROM Rating GROUP BY movieId ORDER BY ratingSum DESC LIMIT 10;")
    List<MovieRatingResult> findTop10MovieRating();
}
