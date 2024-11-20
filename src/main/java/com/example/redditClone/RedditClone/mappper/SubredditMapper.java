package com.example.redditClone.RedditClone.mappper;

import com.example.redditClone.RedditClone.dto.SubredditDto;
import com.example.redditClone.RedditClone.model.Post;
import com.example.redditClone.RedditClone.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel ="spring")
public interface SubredditMapper{

    SubredditDto mapSubredditToDto(Subreddit subreddit);

//    default Integer mapPosts(List<Post> numberOfPosts) {
//        return numberOfPosts.size();
//    }


    @InheritInverseConfiguration
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);
}
