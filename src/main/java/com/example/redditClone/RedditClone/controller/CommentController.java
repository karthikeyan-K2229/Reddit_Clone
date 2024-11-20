package com.example.redditClone.RedditClone.controller;

import com.example.redditClone.RedditClone.model.Comment;
import com.example.redditClone.RedditClone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/postComment")
    public ResponseEntity<Void> createComment(@RequestBody Comment commentsDto){
        commentService.save(commentsDto);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/by-post/{postId}")
    public ResponseEntity<List<Comment>> getAllCommentsForPost(@PathVariable Long postId){
        return ResponseEntity.status(OK).body(commentService.getAllCommentsForPost(postId));
    }

}
