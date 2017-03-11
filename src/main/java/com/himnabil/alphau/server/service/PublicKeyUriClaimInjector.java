package com.himnabil.alphau.server.service;

import com.auth0.jwt.JWTCreator.Builder;
import com.himnabil.alphau.server.model.User;

/**
 * @author himna
 * @since 3/11/2017.
 */
public class PublicKeyUriClaimInjector implements ClaimsInjector<User , Builder>
{
    private String claimName = "publicKeyUri";
    private String publicKeyUri;

    public PublicKeyUriClaimInjector(String publicKeyUri){
        this.publicKeyUri = publicKeyUri;
    }

    @Override
    public Builder inject(Builder builder, User user) {
        return builder.withClaim(claimName , publicKeyUri);
    }
}
