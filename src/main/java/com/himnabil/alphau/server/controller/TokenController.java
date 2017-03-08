package com.himnabil.alphau.server.controller;

import com.himnabil.alphau.server.model.TokenRequestBody;
import com.himnabil.alphau.server.model.User;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.JWTokenizer;
import com.himnabil.alphau.server.service.PasswordUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


@RestController
public class TokenController {

    private UserRepository userRepository ;
    private JWTokenizer tokenizer ;
    private PasswordUtils passwordUtils;

    public TokenController (UserRepository userRepository , JWTokenizer tokenizer , PasswordUtils passwordUtils){
        this.userRepository = userRepository ;
        this.tokenizer = tokenizer ;
        this.passwordUtils = passwordUtils ;
    }

    @RequestMapping(path = "/token" , method = RequestMethod.POST)
    public ResponseEntity<String> token( @RequestBody TokenRequestBody request )
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = userRepository.find( request.getAppName() , request.getUserName());
            if (user == null) {
            return  new ResponseEntity<>("User not found" , HttpStatus.NOT_FOUND);
        }
        if (! passwordUtils.checkPassword(user.getHashedPassword() , request.getPassword())){
            return  new ResponseEntity<>("Invalid password" , HttpStatus.BAD_REQUEST);
        }
        String token = tokenizer.tokenizeUser(user);
        return new ResponseEntity<>( token , HttpStatus.OK);
    }
}
