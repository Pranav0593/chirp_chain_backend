package com.example.oop.Requests;

public class UpdateCommentRequest {
    private String commentBody;
    private Integer commentID;

    public UpdateCommentRequest(String commentBody, Integer commentID) {
        this.commentBody = commentBody;
        this.commentID = commentID;
    }

    public UpdateCommentRequest() {
    }

    public String getCommentBody() {
        return commentBody;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }
}
