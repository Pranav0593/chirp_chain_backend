package com.example.oop.Requests;

public class CreatePostRequest {
    private String postBody;
    private Integer userID;

    public CreatePostRequest(String postBody, Integer userID) {
        this.postBody = postBody;
        this.userID = userID;
    }


    public CreatePostRequest() {
    }

    
    public String getPostBody() {
        return postBody;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }


    public void setUserID(Integer userID) {
        this.userID = userID;
    }



}