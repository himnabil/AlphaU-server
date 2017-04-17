package com.himnabil.alphau.server.controller;

import com.himnabil.alphau.server.ApiErrors;
import com.himnabil.alphau.server.model.TokenRequestBody;
import com.himnabil.alphau.server.model.User;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.PasswordUtils;
import com.himnabil.alphau.server.service.Tokenizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TokenController {

    private UserRepository userRepository ;
    private Tokenizer<User , ?> tokenizer ;
    private PasswordUtils passwordUtils;

    public TokenController (UserRepository userRepository , Tokenizer<User , ?> tokenizer , PasswordUtils passwordUtils){
        this.userRepository = userRepository ;
        this.tokenizer = tokenizer ;
        this.passwordUtils = passwordUtils ;
    }

    @RequestMapping(path = "/token" , method = RequestMethod.POST)
    public ResponseEntity<?> token( @RequestBody TokenRequestBody request ) {
        User user = userRepository.find( request.getAppName() , request.getUserName(), request.getProperties());
            if (user == null) {
            return  new ResponseEntity<>(ApiErrors.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        if (! passwordUtils.checkPassword(user.getHashedPassword() , request.getPassword())){
            return  new ResponseEntity<>(ApiErrors.INVALIDE_PASSWORD , HttpStatus.BAD_REQUEST);
        }
        String token = tokenizer.tokenize(user);
        return new ResponseEntity<>( token , HttpStatus.OK);
    }
}
