package com.himnabil.alphau.server.service;


import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author himna
 * @since 2/12/2017.
 */
@Service
public class PasswordUtils {

    public String hash (String password)  {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update( password.getBytes("UTF-8") );

            return new String(md.digest());
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e){

            e.printStackTrace();
            return null;
        }

    }

    public boolean checkPassword(String hashedPassword , String entreePassword ) {
        return hashedPassword.equals( hash(entreePassword) );
    }

}
