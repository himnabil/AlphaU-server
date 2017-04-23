package com.himnabil.alphau.server;

import com.himnabil.alphau.server.controller.SubscribeController;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.PasswordUtils;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by himna on 2/12/2017.
 */
@Configuration
public class UserManagementConfiguration {


    @Bean
    public UserRepository userRepository (MongoDatabase database) {
        return new UserRepository( database );
    }

    @Bean
    public SubscribeController subscribeController (UserRepository userRepository , PasswordUtils passwordUtils){
        return new SubscribeController(userRepository,passwordUtils);
    }
}
