package com.example.redditClone.RedditClone.repository;


import com.example.redditClone.RedditClone.model.Post;
import com.example.redditClone.RedditClone.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
