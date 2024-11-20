package com.example.redditClone.RedditClone.repository;

import com.example.redditClone.RedditClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String currentMail);

    User findByEmailAndPassword(String currMail, String currPassowrd);
}
