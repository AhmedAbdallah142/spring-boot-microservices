package com.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieController {



    @Autowired
    public MovieRepo movieRepo;


    @PostMapping("/addMovie")
    public String saveMovie(@RequestBody MovieMongo movie) {
        movieRepo.save(movie);
        return "Added Movie with id : " + movie.getMovieId();
    }

    @GetMapping("/findMovie/{id}")
    public Optional<MovieMongo> getBook(@PathVariable int id) {
        return (movieRepo.findById(id));
    }


}
