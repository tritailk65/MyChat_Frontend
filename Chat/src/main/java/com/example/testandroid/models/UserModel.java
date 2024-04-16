package com.example.testandroid.models;

import androidx.annotation.Nullable;

public class UserModel {
    @Nullable
    public String email,password;

    public UserModel(@Nullable String email, @Nullable String password) {
        this.email = email;
        this.password = password;
    }

    // getter and setter methods
    // for email variable
    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    // getter and setter methods
    // for password variable
    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}
