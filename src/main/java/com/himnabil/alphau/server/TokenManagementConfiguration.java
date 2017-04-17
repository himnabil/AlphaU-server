package com.himnabil.alphau.server;

import com.auth0.jwt.JWTCreator;
import com.himnabil.alphau.server.controller.TokenController;
import com.himnabil.alphau.server.model.User;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.Collection;

/**
 * @author himna
 * @since 2/13/2017.
 */
@Configuration
public class TokenManagementConfiguration {

    @Value("${alphau.server.public.key.uri}")
    private String publicKeyUri;

    @Bean
    public Collection<ClaimsInjector<User, JWTCreator.Builder>> claimsInjectors () {
        Collection<ClaimsInjector<User, JWTCreator.Builder>> injectorsList = new ArrayList<>();

        injectorsList.add ( new PublicKeyUriClaimInjector(publicKeyUri) );

        return injectorsList;
    }

    @Bean
    public Tokenizer<User , JWTCreator.Builder> userTokenizer (KeysManager keysManager , Collection<ClaimsInjector<User, JWTCreator.Builder>> injectorsList){
        Tokenizer<User , JWTCreator.Builder> userTokenizer = new JWTUserTokenizer(keysManager);
        userTokenizer.setClaimInjectors(injectorsList);
        return userTokenizer;
    }

    @Bean
    public PasswordUtils passwordUtils (){
        return new PasswordUtils();
    }

    @Bean
    public TokenController tokenController (
            UserRepository userRepository ,
            @Qualifier("userTokenizer") Tokenizer<User , ?> tokenizer,
            PasswordUtils passwordUtils
    ){
        return new TokenController(userRepository ,tokenizer ,passwordUtils);
    }
}
