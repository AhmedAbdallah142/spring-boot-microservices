package com.trendingMovieService;

import com.trendingMovieService.trendingService.TrendingServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class TrendingMoviesServiceApplication {

    private final int TIMEOUT = 3000;   // 3 seconds
    private static final int SERVER_PORT = 9090;   // 3 seconds

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(TIMEOUT);   // Set the timeout to 3 seconds
        return new RestTemplate(clientHttpRequestFactory);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(TrendingMoviesServiceApplication.class, args);
        Server server = ServerBuilder.forPort(SERVER_PORT).addService(new TrendingServiceImpl()).build();
        server.start();
        System.out.println("Server Started at " + server.getPort());
        server.awaitTermination();
    }

}
