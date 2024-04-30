package com.example.oop.Entities;

import jakarta.persistence.*;


@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentID;

    private String commentBody;

    @Embedded
    private CommentCreator commentCreator;

    @ManyToOne
    @JoinColumn(name = "post_id")
//    @JsonBackReference

    private Post post;

    public Comment(String commentBody, CommentCreator commentCreator, Post post) {
        this.commentBody = commentBody;
        this.commentCreator = commentCreator;
        this.post = post;
    }

    public Comment() {}

    // Getters and setters

    public Integer getCommentID() {

        return commentID;
    }

    public void setCommentID(Integer id) {

        this.commentID = id;
    }

    public String getCommentBody()
    {
        return commentBody;
    }

    public void setCommentBody(String body) {

        this.commentBody = body;
    }

    public CommentCreator getCommentCreator() {

        return commentCreator;
    }

    public void setCommentCreator(CommentCreator commentCreator)
    {

        this.commentCreator = commentCreator;
    }


    public void setPost(Post post) {

        this.post = post;
    }

}




