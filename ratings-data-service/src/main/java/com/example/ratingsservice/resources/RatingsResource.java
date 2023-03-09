package com.example.ratingsservice.resources;

import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.TrendingMovies;
import com.example.ratingsservice.models.UserRating;
import com.example.ratingsservice.models.UserRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
    @Autowired
    private UserRatingsRepository userRatingsRepository;

    @RequestMapping("/{userId}")
    public Optional<UserRating> getRatingsOfUser(@PathVariable String userId) {
        return userRatingsRepository.findById(userId);
    }

    @RequestMapping("/top10Movies")
    public TrendingMovies top10Movies() {
        return new TrendingMovies(userRatingsRepository.findTop10MovieRating());
    }
}
