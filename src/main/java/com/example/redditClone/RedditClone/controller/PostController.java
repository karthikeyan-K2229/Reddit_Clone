package com.example.redditClone.RedditClone.controller;

import com.example.redditClone.RedditClone.dto.PostRequest;
import com.example.redditClone.RedditClone.dto.PostResponse;
import com.example.redditClone.RedditClone.dto.SubredditDto;
import com.example.redditClone.RedditClone.model.Post;
import com.example.redditClone.RedditClone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/api/SavePosts")
    public ResponseEntity<Post> SavePost(@RequestBody PostRequest postRequest)
    {
        //postService.SavePosts(postRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).body(postService.SavePosts(postRequest));
    }


    @GetMapping("/api/getAllposts")
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }


    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long postId) {
        //System.out.println(postService.getPost(postId));
        return status(HttpStatus.OK).body(postService.getPost(postId));

    }




}
