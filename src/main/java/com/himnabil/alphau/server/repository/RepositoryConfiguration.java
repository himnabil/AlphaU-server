package com.himnabil.alphau.server.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by himna on 2/12/2017.
 */
@Configuration
public class RepositoryConfiguration {

    @Bean
    public MongoDatabase database (){
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);
        return mongoClient.getDatabase("AlphaU");
    }


}
