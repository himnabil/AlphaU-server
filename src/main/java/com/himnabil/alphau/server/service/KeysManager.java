package com.himnabil.alphau.server.service;

import org.springframework.stereotype.Service;

import java.security.*;

@Service
public class KeysManager {

    private KeyPair keys ;

    public KeysManager () throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        keys = keyGen.generateKeyPair();
    }

    public PublicKey getPublicKey(){
        return keys.getPublic();
    }
    public PrivateKey getPrivateKey(){
        return keys.getPrivate();
    }
}
