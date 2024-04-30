package com.example.oop.Entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class CommentCreator {

    private int userID;
    private String name;

    public CommentCreator() {
    }

    public CommentCreator(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
