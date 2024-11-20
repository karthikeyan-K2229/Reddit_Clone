package com.example.redditClone.RedditClone.exception;

public class SubredditNotFoundException extends RuntimeException {

        public SubredditNotFoundException(String subredditName) {
            super(subredditName);

    }
}
