package com.example.ratingsservice.models;
import org.springframework.data.repository.CrudRepository;

public interface UserRatingsRepository extends CrudRepository<UserRating, String>{
}
