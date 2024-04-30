package com.example.oop.Entities;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;


    private String email;



    private String password;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;


    public AppUser(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        posts=new ArrayList<>();

    }

    public AppUser() {
        posts=new ArrayList<>();
    }


    // Getters and setters

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void addPost(Post post) {
        posts.add(post);

    }


}