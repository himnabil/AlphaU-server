package com.himnabil.alphau.server.controller;

import com.himnabil.alphau.server.ApiErrors;
import com.himnabil.alphau.server.model.AuthRequest;
import com.himnabil.alphau.server.model.User;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.PasswordUtils;
import com.himnabil.alphau.server.service.Tokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TokenController {

    private static final Logger log = LoggerFactory.getLogger(TokenController.class);

    private UserRepository userRepository ;
    private Tokenizer<User , ?> tokenizer ;
    private PasswordUtils passwordUtils;

    public TokenController (UserRepository userRepository , Tokenizer<User , ?> tokenizer , PasswordUtils passwordUtils){
        this.userRepository = userRepository ;
        this.tokenizer = tokenizer ;
        this.passwordUtils = passwordUtils ;
    }

    @RequestMapping(path = "/token" , method = RequestMethod.POST)
    public ResponseEntity<?> token( @RequestBody AuthRequest request ) {
        log.info(" GET /token : RequestBody: {}" , request);
        User user = userRepository.find( request );
        if (user == null) {
             log.error("{}", ApiErrors.USER_NOT_FOUND);
             return  new ResponseEntity<>(ApiErrors.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        if (! passwordUtils.checkPassword(user.getHashedPassword() , request.getPassword())){
            log.error("{}", ApiErrors.INVALID_PASSWORD);
            return  new ResponseEntity<>(ApiErrors.INVALID_PASSWORD , HttpStatus.BAD_REQUEST);
        }
        String token = tokenizer.tokenize(user);
        return new ResponseEntity<>( token , HttpStatus.OK);
    }
}
