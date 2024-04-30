package com.example.oop.Requests;

public class DeletePostRequest
{
    private Integer postID;

    public DeletePostRequest(Integer postID)
    {
        this.postID = postID;
    }

    public DeletePostRequest()
    {

    }
    public Integer getPostID()
    {
        return postID;
    }

    public void setPostID(Integer postID)
    {
        this.postID = postID;
    }

}
