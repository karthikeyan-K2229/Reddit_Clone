package com.example.redditClone.RedditClone.controller;

import com.example.redditClone.RedditClone.model.Subreddit;
import com.example.redditClone.RedditClone.model.User;
import com.example.redditClone.RedditClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user)throws Exception
    {
        try {
            User userObj = null;
            userObj = userService.saveUser(user);
            return new ResponseEntity<User>(userObj, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> Login(@RequestBody User user)throws Exception
    {
        User userObj=null;
        userObj=userService.fetchByEmail(user);
        if(userObj==null)
        {
            return new ResponseEntity("not found",HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<User>(userObj,HttpStatus.OK);
    }
}
