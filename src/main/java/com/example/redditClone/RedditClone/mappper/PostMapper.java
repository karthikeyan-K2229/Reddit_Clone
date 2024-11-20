package com.example.redditClone.RedditClone.mappper;

import com.example.redditClone.RedditClone.dto.PostRequest;
import com.example.redditClone.RedditClone.dto.PostResponse;
import com.example.redditClone.RedditClone.dto.SubredditDto;
import com.example.redditClone.RedditClone.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public  interface PostMapper {


    @Mapping(target = "voteCount", constant = "0")
    Post mapDtoToPost(PostRequest postRequest);

//    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
//    @Mapping(target = "duration", expression = "java(getDuration(post))")
//    @Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
//    @Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
    PostResponse mapPostToDto(Post post);
}
//    Integer commentCount(Post post) {
//        return commentRepository.findByPost(post).size();
//    }
//
//    String getDuration(Post post) {
//        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
//    }
//
//    boolean isPostUpVoted(Post post) {
//        return checkVoteType(post, UPVOTE);
//    }
//
//    boolean isPostDownVoted(Post post) {
//        return checkVoteType(post, DOWNVOTE);
//    }
//
//    private boolean checkVoteType(Post post, VoteType voteType) {
//        if (authService.isLoggedIn()) {
//            Optional<Vote> voteForPostByUser =
//                    voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
//                            authService.getCurrentUser());
//            return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType))
//                    .isPresent();
//        }
//        return false;
//    }

