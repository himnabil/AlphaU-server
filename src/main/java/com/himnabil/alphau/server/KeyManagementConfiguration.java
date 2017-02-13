package com.himnabil.alphau.server;

import com.himnabil.alphau.server.controller.PublicKeyController;
import com.himnabil.alphau.server.service.KeysManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.NoSuchAlgorithmException;


@Configuration
public class KeyManagementConfiguration {

    @Bean
    public KeysManager keysManager () throws NoSuchAlgorithmException {
        return new KeysManager();
    }

    @Bean
    public PublicKeyController publicKeyController(KeysManager manager ){
        return new PublicKeyController(manager);
    }
}
