package com.example.redditClone.RedditClone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

import static jakarta.persistence.GenerationType.IDENTITY;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Component
public class Subreddit {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank(message = "Community name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;

    private Instant createdDate;
    private Long userId;

}
