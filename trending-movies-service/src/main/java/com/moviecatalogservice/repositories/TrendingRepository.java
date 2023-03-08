package com.moviecatalogservice.repositories;

import com.moviecatalogservice.models.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrendingRepository extends CrudRepository<Rating, String> {

    @Query(nativeQuery = true, value = "SELECT movie_id FROM Rating GROUP BY movie_id ORDER BY SUM(rating) DESC LIMIT 10;")
    List<String> findTop10MovieRating();
}
