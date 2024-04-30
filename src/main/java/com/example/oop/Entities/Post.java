package com.example.oop.Entities;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postID;
    private String date;
    private String postBody;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
    private List<Comment> comments;


   public Post(String body) {
        this.postBody = body;
       Date createdAt = new Date();
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         this.date = dateFormat.format(createdAt);

   }

    public Post() {
        Date createdAt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = dateFormat.format(createdAt);
    }


    // Getters and setters



    public Integer getPostID()
    {

        return postID;
    }

    public void setPostID(Integer id)
    {

        this.postID = id;
    }

    public String getPostBody()
    {

        return postBody;
    }

    public void setPostBody(String body) {

        this.postBody = body;
    }

    public List<Comment> getComments() {

        return comments;
    }

    public void setComments(List<Comment> comments) {

        this.comments = comments;
    }


    public void addComment(Comment comment)
    {
        comments.add(comment);
    }



    public void setUser(AppUser appUser) {

        this.appUser = appUser;
    }

    public String getDate() {
        return date;
    }




}