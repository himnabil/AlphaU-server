package com.himnabil.alphau.server.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.himnabil.alphau.server.model.User;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.interfaces.RSAKey;

/**
 * @author himnabil
 */
@Service
public class JWTokenizer {

    private PrivateKey privateKey ;

    public JWTokenizer (KeysManager keysManager){
        this.privateKey = keysManager.getPrivateKey();
    }

    public String tokenizeUser (User user){
        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("user_name", user.getUserName())
                .withClaim("app_name", user.getAppName())
                .withClaim("app_id", user.getAppId())
                .sign(Algorithm.RSA256((RSAKey) privateKey));
    }
}
