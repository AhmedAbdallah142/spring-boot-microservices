package com.moviecatalogservice.resources;

import com.moviecatalogservice.models.*;
import com.moviecatalogservice.services.MovieInfoService;
import com.moviecatalogservice.services.TrendingMovieService;
import com.moviecatalogservice.services.UserRatingService;
import com.trendingGrpc.TrendingRequest;
import com.trendingGrpc.TrendingResponse;
import com.trendingGrpc.TrendingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    private final RestTemplate restTemplate;

    private final MovieInfoService movieInfoService;

    private final UserRatingService userRatingService;

    private final TrendingMovieService trendingMovieService;

    public MovieCatalogResource(RestTemplate restTemplate,
                                MovieInfoService movieInfoService,
                                UserRatingService userRatingService,
                                TrendingMovieService trendingMovieService) {

        this.restTemplate = restTemplate;
        this.movieInfoService = movieInfoService;
        this.userRatingService = userRatingService;
        this.trendingMovieService = trendingMovieService;
    }

    /**
     * Makes a call to MovieInfoService to get movieId, name and description,
     * Makes a call to RatingsService to get ratings
     * Accumulates both data to create a MovieCatalog
     *
     * @param userId
     * @return CatalogItem that contains name, description and rating
     */
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        List<Rating> ratings = userRatingService.getUserRating(userId).getRatings();
        return ratings.stream().map(movieInfoService::getCatalogItem).collect(Collectors.toList());
    }

    @RequestMapping("/top10Movies")
    public TrendingMovies getTrendingMovies() {
        return trendingMovieService.getTop10TrendingMovie();
    }

    private final int SERVER_PORT = 9090;

    @RequestMapping("/top10MoviesTest")
    public List<Movie> top10Movies() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", SERVER_PORT).usePlaintext().build();
        TrendingServiceGrpc.TrendingServiceBlockingStub trendingServiceBlockingStub = TrendingServiceGrpc.newBlockingStub(managedChannel);
        TrendingRequest trendingRequest = TrendingRequest.newBuilder().build();
        TrendingResponse response = trendingServiceBlockingStub.getTop10Movies(trendingRequest);
        List<Movie> top10 = new LinkedList<>();
        for (String movieId : response.getMovieIdList()) {
            top10.add(movieInfoService.getMovieItem(movieId));
        }
        return top10;
    }
}
