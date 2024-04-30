package com.example.oop.Responses;

import com.example.oop.Entities.AppUser;
import com.example.oop.Entities.Comment;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponse
{
    private Integer postId;
    private String body;
    private LocalDateTime createdAt;
    private AppUser appUser;
    private List<Comment> comments;

    // Default constructor
    public PostResponse()
    {
    }

    // Constructor with body, createdAt, user, and comments

    public PostResponse(Integer postId, String body, AppUser appUser, List<Comment> comments)
    {
        this.postId = postId;
        this.body = body;
        this.appUser = appUser;
        this.createdAt=LocalDateTime.now();
        this.comments = comments;
    }


    // Getters and setters

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getBody() {

        return body;
    }

    public void setBody(String body) {

        this.body = body;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;
    }

    public AppUser getUser() {

        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<Comment> getComments() {
        return
                comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}