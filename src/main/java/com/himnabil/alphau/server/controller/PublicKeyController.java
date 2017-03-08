package com.himnabil.alphau.server.controller;

import com.himnabil.alphau.server.service.KeysManager;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

/**
 * Created by himna on 2/11/2017.
 */
@RestController
public class PublicKeyController {

    public PublicKeyController( KeysManager manager ){
        this.manager= manager ;
    }

    private KeysManager manager;

    @RequestMapping("/key")
    public String key (){
        return Base64.encodeBase64String(manager.getPublicKey().getEncoded());
    }

}
