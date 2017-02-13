package com.himnabil.alphau.server;

import com.himnabil.alphau.server.controller.UserController;
import com.himnabil.alphau.server.repository.UserRepository;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by himna on 2/12/2017.
 */
@Configuration
public class UserManagementConfiguration {


    @Bean
    public UserController userController (UserRepository repository){
        return new UserController(repository);
    }

    @Bean
    public UserRepository userRepository (MongoDatabase database) {
        return new UserRepository( database );
    }
}
