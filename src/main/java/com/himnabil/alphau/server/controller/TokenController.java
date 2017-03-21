package com.himnabil.alphau.server.controller;

import com.himnabil.alphau.server.model.TokenRequestBody;
import com.himnabil.alphau.server.model.User;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.PasswordUtils;
import com.himnabil.alphau.server.service.Tokenizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity<String> token( @RequestBody TokenRequestBody request ) {
        User user = userRepository.find( request.getAppName() , request.getUserName());
            if (user == null) {
            return  new ResponseEntity<>("User not found" , HttpStatus.NOT_FOUND);
        }
        if (! passwordUtils.checkPassword(user.getHashedPassword() , request.getPassword())){
            return  new ResponseEntity<>("Invalid password" , HttpStatus.BAD_REQUEST);
        }
        String token = tokenizer.tokenize(user);
        return new ResponseEntity<>( token , HttpStatus.OK);
    }
}
