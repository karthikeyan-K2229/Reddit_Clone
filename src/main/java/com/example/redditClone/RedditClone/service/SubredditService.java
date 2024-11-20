package com.example.redditClone.RedditClone.service;

import com.example.redditClone.RedditClone.dto.SubredditDto;
import com.example.redditClone.RedditClone.exception.SubredditNotFoundException;
import com.example.redditClone.RedditClone.mappper.SubredditMapper;
import com.example.redditClone.RedditClone.model.Subreddit;
import com.example.redditClone.RedditClone.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubredditService {
    @Autowired
    SubredditRepository subredditRepository;
    @Autowired
    private SubredditMapper subredditMapper;
    public SubredditDto saveSubreddit(SubredditDto subredditDto) {

        Subreddit object=subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(object.getId());

        return subredditDto;

    }

    public List<SubredditDto> getAllSubreddit() {
        return subredditRepository
                .findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(Collectors.toList());
    }

    public Optional<Object> fetchById(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SubredditNotFoundException("No subreddit found with ID - " + id));
        return Optional.ofNullable(subredditMapper.mapSubredditToDto(subreddit));
    }

}
