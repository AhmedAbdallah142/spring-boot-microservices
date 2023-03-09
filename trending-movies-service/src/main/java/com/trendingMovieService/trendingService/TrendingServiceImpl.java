package com.trendingMovieService.trendingService;


import com.trendingGrpc.TrendingRequest;
import com.trendingGrpc.TrendingResponse;
import com.trendingGrpc.TrendingServiceGrpc.TrendingServiceImplBase;
import io.grpc.stub.StreamObserver;


public class TrendingServiceImpl extends TrendingServiceImplBase {

    @Override
    public void getTop10Movies(TrendingRequest request, StreamObserver<TrendingResponse> responseObserver) {
        TrendingResponse.Builder response = TrendingResponse.newBuilder();
        response.addMovieId("0");
        response.addMovieId("1");
        response.addMovieId("2");
        response.addMovieId("3");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
