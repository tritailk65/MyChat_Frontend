package com.example.testandroid.models;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {
    @SerializedName("resultObj")
    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}