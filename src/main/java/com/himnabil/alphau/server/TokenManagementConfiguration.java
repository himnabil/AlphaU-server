package com.himnabil.alphau.server;

import com.himnabil.alphau.server.controller.TokenController;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.JWTokenizer;
import com.himnabil.alphau.server.service.KeysManager;
import com.himnabil.alphau.server.service.PasswordUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by himna on 2/13/2017.
 */
@Configuration
public class TokenManagementConfiguration {

    @Bean
    public JWTokenizer tokenizer (KeysManager keysManager){
        return new JWTokenizer(keysManager);
    }

    @Bean
    public PasswordUtils passwordUtils (){
        return new PasswordUtils();
    }

    @Bean
    public TokenController tokenController (UserRepository userRepository , JWTokenizer tokenizer, PasswordUtils passwordUtils){
        return new TokenController(userRepository ,tokenizer ,passwordUtils);
    }
}
