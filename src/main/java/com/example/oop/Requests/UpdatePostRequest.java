package com.example.oop.Requests;


public class UpdatePostRequest {
    private String postBody;
    private Integer postID;

    public UpdatePostRequest(String postBody, Integer postID)
    {
        this.postBody = postBody;
        this.postID = postID;
    }

    public UpdatePostRequest()
    {
    }

    public Integer getPostID() {
        return postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }




}