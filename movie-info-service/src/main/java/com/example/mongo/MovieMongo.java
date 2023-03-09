package com.example.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collation = "Movie")
public class MovieMongo {
    @Id
    private int movieId;
    private String name;
    private String description;


}
