package com.himnabil.alphau.server.controller;

import com.himnabil.alphau.server.ApiErrors;
import com.himnabil.alphau.server.model.AuthRequestBody;
import com.himnabil.alphau.server.model.User;
import com.himnabil.alphau.server.model.UserSubscriptionResult;
import com.himnabil.alphau.server.model.builder.UserBuilder;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author himna
 * @since 4/23/2017.
 */
@RestController
public class SubscribeController {

    private static final Logger log = LoggerFactory.getLogger(SubscribeController.class);
    private UserRepository userRepository ;
    private PasswordUtils passwordUtils;

    public SubscribeController(
            UserRepository userRepository,
            PasswordUtils passwordUtils
    ){
        this.userRepository = userRepository;
        this.passwordUtils = passwordUtils;
    }

    @RequestMapping(path = "/subscribe" , method = RequestMethod.POST)
    public ResponseEntity<?> subscribe (@RequestBody AuthRequestBody request){
        log.info("POST /subscribe : RequestBody = {}" , request);
        User user = userRepository.find(request);
        if (user != null){
            log.error("{}", ApiErrors.USER_ALREADY_EXIST);
            return new ResponseEntity<>(ApiErrors.USER_ALREADY_EXIST, HttpStatus.BAD_REQUEST);
        }

        Map<String,Object> properties = new HashMap<>();
        properties.putAll( request.getProperties());

        user = userRepository.save(
                new UserBuilder()
                        .setAppName( request.getAppName() )
                        .setUserName( request.getUserName())
                        .setHashedPassword( passwordUtils.hash( request.getPassword() ) )
                        .setProperties( properties )
                        .build()
        );

        return new ResponseEntity<>( new UserSubscriptionResult(user) , HttpStatus.ACCEPTED );
    }
}
