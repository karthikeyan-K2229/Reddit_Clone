package com.example.redditClone.RedditClone.service;

import com.example.redditClone.RedditClone.model.User;
import com.example.redditClone.RedditClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private User user;


    public User saveUser(User user) throws Exception {
        {
            String currentMail = user.getEmail();
            User userObj = userRepository.findByEmail(currentMail);
            if (userObj != null) {
                throw new Exception("Email id already exists !!!");
            }
            user.setCreated(Instant.now());
            user.setEnabled(false);
            return userRepository.save(user);
        }
    }

    public User fetchByEmail(User user) {
        String CurrMail = user.getEmail();
        String CurrPassowrd = user.getPassword();
        User user1 = userRepository.findByEmailAndPassword(CurrMail, CurrPassowrd);
        return user1;
    }

    public User getCurrentUser()
    {
        User getuser=new User();
       getuser.setEmail(user.getEmail());
       getuser.setUserId(user.getUserId());
       getuser.setUsername(user.getUsername());
       getuser.setCreated(user.getCreated());
       getuser.setEnabled(user.isEnabled());
       return getuser;

    }

}
