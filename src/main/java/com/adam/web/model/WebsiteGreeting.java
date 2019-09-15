package com.adam.web.model;

public class WebsiteGreeting {
    private int id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
