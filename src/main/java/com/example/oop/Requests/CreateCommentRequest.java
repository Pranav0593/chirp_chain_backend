package com.example.oop.Requests;

public class CreateCommentRequest {
    private String commentBody;
    private Integer userID;
    private Integer postID;

    public CreateCommentRequest(String commentBody, Integer userID, Integer postID) {
        this.commentBody = commentBody;
        this.userID = userID;
        this.postID = postID;
    }

    public CreateCommentRequest() {
    }

    public String getCommentBody() {
        return commentBody;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }
}
