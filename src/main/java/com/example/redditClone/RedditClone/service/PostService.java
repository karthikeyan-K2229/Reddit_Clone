package com.example.redditClone.RedditClone.service;

import com.example.redditClone.RedditClone.dto.PostRequest;
import com.example.redditClone.RedditClone.dto.PostResponse;
import com.example.redditClone.RedditClone.dto.SubredditDto;
import com.example.redditClone.RedditClone.exception.PostNotFoundException;
import com.example.redditClone.RedditClone.exception.SubredditNotFoundException;
import com.example.redditClone.RedditClone.model.Post;
import com.example.redditClone.RedditClone.model.Subreddit;
import com.example.redditClone.RedditClone.model.User;
import com.example.redditClone.RedditClone.repository.PostRepository;
import com.example.redditClone.RedditClone.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.redditClone.RedditClone.mappper.PostMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SubredditRepository subredditRepository;
    @Autowired(required = true)
    private  PostMapper postMapper;



    public Post SavePosts(PostRequest postRequest) {
        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
        return postRepository.save(postMapper.mapDtoToPost(postRequest));
    }


    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId.toString()));
        System.out.println(postMapper.mapPostToDto(post));
        return postMapper.mapPostToDto(post);
    }


    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapPostToDto)
                .collect(Collectors.toList());

    }




}
