package com.example.oop.Requests;

public class DeleteCommentRequest
{
    private Integer commentID;

    public DeleteCommentRequest(Integer commentID) {
        this.commentID = commentID;
    }

    public DeleteCommentRequest() {
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }
}
