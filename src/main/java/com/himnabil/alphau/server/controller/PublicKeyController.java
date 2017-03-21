package com.himnabil.alphau.server.controller;

import com.himnabil.alphau.server.service.KeysManager;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by himna on 2/11/2017.
 */
@RestController
public class PublicKeyController {

    private KeysManager manager;

    public PublicKeyController( KeysManager manager ){
        this.manager= manager ;
    }

    @RequestMapping("/key")
    public String key (){
        return Base64.encodeBase64String(manager.getPublicKey().getEncoded());
    }

}
