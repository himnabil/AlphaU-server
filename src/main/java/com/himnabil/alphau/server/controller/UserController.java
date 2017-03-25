package com.himnabil.alphau.server.controller;

import com.himnabil.alphau.server.model.User;
import com.himnabil.alphau.server.repository.UserRepository;
import com.himnabil.alphau.server.service.PasswordUtils;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author himna
 * @since 2/12/2017.
 */
@RestController
public class UserController {

    private UserRepository repository ;

    public UserController (UserRepository repository){
        this.repository = repository ;
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> subscription (@RequestBody User user , @RequestAttribute(name = "ata" , required = false) String toto ){
        User savedUser = repository.save(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getUser () {
        PasswordUtils passwordUtils = new PasswordUtils();
        User user = new User();
        user.setId(new ObjectId().toHexString());
        user.setUserName("himnabil");
        user.setHashedPassword(passwordUtils.hash("viveMoi31."));
        user.setAppName("ubsunu");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
