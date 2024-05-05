package com.example.testandroid.models;

import androidx.annotation.Nullable;

public class AuthRequest {

    @Nullable
    public String email, password;
    public boolean rememberMe = true;
    public AuthRequest(){}

    public AuthRequest(@Nullable String email, @Nullable String password) {
        this.email = email;
        this.password = password;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}