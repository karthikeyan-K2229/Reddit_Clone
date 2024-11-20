package com.example.redditClone.RedditClone.controller;

import com.example.redditClone.RedditClone.dto.SubredditDto;
import com.example.redditClone.RedditClone.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SubredditController {

    @Autowired
    private SubredditService subredditService;

    @PostMapping("/createSubreddit")
    public ResponseEntity<SubredditDto> createSubReddit(@RequestBody SubredditDto subredditDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(subredditService.saveSubreddit(subredditDto));
    }

    @GetMapping("/getAllSubreddit")
    public ResponseEntity<List<SubredditDto>> getAllSubreddit()
    {
        return ResponseEntity.status(HttpStatus.OK).body(subredditService.getAllSubreddit());
    }

    @GetMapping({"/id"})
    public ResponseEntity<Optional<Object>> getSubredditById(@PathVariable Long id)
    {
        Optional<Object> subreddit=subredditService.fetchById(id);
        return ResponseEntity.ok(subreddit);
    }

}
