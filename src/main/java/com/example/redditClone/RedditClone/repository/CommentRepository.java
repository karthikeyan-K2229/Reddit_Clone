package com.example.redditClone.RedditClone.repository;

import com.example.redditClone.RedditClone.model.Comment;
import com.example.redditClone.RedditClone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPostId(Long postId);
}
