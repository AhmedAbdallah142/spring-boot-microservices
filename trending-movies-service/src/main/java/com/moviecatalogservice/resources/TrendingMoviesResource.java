package com.moviecatalogservice.resources;

import com.moviecatalogservice.repositories.TrendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;;

@RestController
@RequestMapping("/trending")
public class TrendingMoviesResource {

    @Autowired
    private TrendingRepository trendingRepository;

    @RequestMapping("/top10Movie")
    public List<String> getRatingsOfUser() {
        return trendingRepository.findTop10By();
    }
}
