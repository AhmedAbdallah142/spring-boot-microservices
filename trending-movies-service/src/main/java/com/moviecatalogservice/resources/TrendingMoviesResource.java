package com.moviecatalogservice.resources;

import com.moviecatalogservice.models.TrendingMovies;
import com.moviecatalogservice.repositories.TrendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/top10")
public class TrendingMoviesResource {

    @Autowired
    private TrendingRepository trendingRepository;

    @RequestMapping("/movies")
    public TrendingMovies getRatingsOfUser() {
        return new TrendingMovies(trendingRepository.findTop10MovieRating());
    }
}
