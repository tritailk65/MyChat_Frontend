package com.example.testandroid.models;

public class UpdateNameRequest {
    public String name;
    public String Avatar;
    public boolean rememberMe = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {return Avatar;}

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }
}
