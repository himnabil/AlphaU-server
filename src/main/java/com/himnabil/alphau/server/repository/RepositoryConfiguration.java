package com.himnabil.alphau.server.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author himna
 * @since 2/12/2017.
 */
@Configuration
public class RepositoryConfiguration {

    @Value("${alphau.db.mongo.uri}")
    String mongodbUri;
    @Value("${alphau.db.mongo.databaseName}")
    String databaseName;

    @Bean
    public MongoDatabase database (){
        MongoClientURI connectionString = new MongoClientURI(mongodbUri);
        MongoClient mongoClient = new MongoClient(connectionString);
        return mongoClient.getDatabase(databaseName);
    }


}
