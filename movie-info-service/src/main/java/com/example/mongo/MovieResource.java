package com.example.mongo;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    MovieController movieController ;
    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public MovieResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {






        MovieMongo movieMongo = new MovieMongo();

        if(movieController.getBook(Integer.parseInt(movieId)).isPresent()){
            Optional<MovieMongo> movieMongoOptional= movieController.getBook(Integer.parseInt(movieId));
            movieMongo = movieMongoOptional.stream().findFirst().orElse(null);
            return new Movie(String.valueOf(movieMongo.getMovieId()), movieMongo.getName(), movieMongo.getDescription());
        }
        else {
            // Get the movie info from TMDB
            final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
            MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);
            Movie movie = new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
            movieMongo.setMovieId(Integer.parseInt(movie.getMovieId()));
            movieMongo.setName(movie.getName());
            movieMongo.setDescription(movie.getDescription());

            movieController.saveMovie(movieMongo);

            return movie;
        }


    }
}
