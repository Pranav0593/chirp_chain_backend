package com.example.oop.Responses;


import com.example.oop.Entities.AppUser;

public class UserResponse {
    private Integer id;
    private String name;
    private String email;

    public static UserResponse fromUser(AppUser appUser) {
        UserResponse userResponse = new UserResponse();
        userResponse.id = appUser.getId();
        userResponse.name = appUser.getName();
        userResponse.email = appUser.getEmail();
        return userResponse;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}