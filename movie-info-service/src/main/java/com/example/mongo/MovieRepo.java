package com.example.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface MovieRepo extends MongoRepository<MovieMongo, Integer> {
}
