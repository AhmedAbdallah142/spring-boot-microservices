package com.trendingMovieService.trendingService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.trendingMovieService.models.TrendingMovies;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Objects;

@Service
public class UserRatingService {

    private final RestTemplate restTemplate;

    public UserRatingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackTop10Trending",
            commandProperties = {
                    // Time to cause timeout
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    // N, Hystrix looks at (analyzes) last N requests.
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    // if >= 50 percent of the last N requests fail, break the circuit
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    // Wait/Sleep for 5 seconds before sending another request to the failed service
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })

    public TrendingMovies getTop10TrendingMovie() {
        String trendingUrl = "http://ratings-data-service/ratings/top10Movies";
        return Objects.requireNonNull(restTemplate.getForObject(trendingUrl, TrendingMovies.class));
    }

    public TrendingMovies getFallbackTop10Trending() {
        return new TrendingMovies();
    }
}
