package com.himnabil.alphau.server.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.himnabil.alphau.server.model.User;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAKey;
import java.util.Collection;

/**
 * @author himnabil
 */
@Service
public class JWTUserTokenizer implements Tokenizer<User, JWTCreator.Builder>{

    private KeysManager keysManager ;
    private JWTCreator.Builder builder ;
    private Collection<ClaimsInjector<User, JWTCreator.Builder>> claimInjectors ;

    public JWTUserTokenizer(KeysManager keysManager){
        this.keysManager = keysManager;
    }



    public String tokenize (User user){
        builder = JWT.create()
                .withClaim("id", user.getId())
                .withClaim("user_name", user.getUserName())
                .withClaim("app_name", user.getAppName()) ;

        claimInjectors.forEach(
                claimsInjector -> builder = claimsInjector.inject(builder , user)
        );

        return builder.sign(Algorithm.RSA256((RSAKey) keysManager.getPrivateKey()));
    }

    @Override
    public void setClaimInjectors(Collection<ClaimsInjector<User, JWTCreator.Builder>> claimInjectors) {
        this.claimInjectors = claimInjectors ;
    }

}
