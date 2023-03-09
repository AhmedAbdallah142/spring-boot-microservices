package com.trendingMovieService.trendingService;


import com.trendingGrpc.TrendingRequest;
import com.trendingGrpc.TrendingResponse;
import com.trendingGrpc.TrendingServiceGrpc.TrendingServiceImplBase;
import com.trendingMovieService.models.MovieRatingResult;
import com.trendingMovieService.models.TrendingMovies;
import io.grpc.stub.StreamObserver;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


public class TrendingServiceImpl extends TrendingServiceImplBase {

    RestTemplate restTemplate = getRestTemplate();

    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(3000);   // Set the timeout to 3 seconds
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Override
    public void getTop10Movies(TrendingRequest request, StreamObserver<TrendingResponse> responseObserver) {
        TrendingResponse.Builder response = TrendingResponse.newBuilder();
        for (MovieRatingResult m : getTop10TrendingMovie().getMovies()){
            response.addMovieId(m.getMovieId());
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public TrendingMovies getTop10TrendingMovie() {
        String trendingUrl = "http://localhost:8083/ratings/top10Movies";
        return Objects.requireNonNull(restTemplate.getForObject(trendingUrl, TrendingMovies.class));
    }
}
