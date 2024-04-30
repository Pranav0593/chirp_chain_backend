package com.example.oop.Responses;

public class UserDetailResponse {

    private String name;
    private Integer userID;
    private String email;

    public UserDetailResponse(String name, Integer userID, String email) {
        this.name = name;
        this.userID = userID;
        this.email = email;
    }

    public UserDetailResponse() {
    }

    public String getName() {
        return name;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
