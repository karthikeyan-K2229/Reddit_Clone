package com.example.redditClone.RedditClone.service;

import com.example.redditClone.RedditClone.exception.PostNotFoundException;
import com.example.redditClone.RedditClone.model.Comment;
import com.example.redditClone.RedditClone.model.Post;
import com.example.redditClone.RedditClone.repository.CommentRepository;
import com.example.redditClone.RedditClone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    public void save(Comment commentsDto){
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        commentsDto.setCreatedDate(java.time.Instant.now());
        commentRepository.save(commentsDto);
    }

    public List<Comment> getAllCommentsForPost(Long postId) {
        Post post =  postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPostId(post.getPostId());
    }

}
