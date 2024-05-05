package com.example.testandroid.models;

import androidx.annotation.Nullable;

import java.util.UUID;

public class UserModel {
    @Nullable
    public String email, username, firstName, lastName, password;

    public UserModel(){}

    public UserModel( @Nullable String email, @Nullable String username, @Nullable String firstName, @Nullable String lastName, @Nullable String password) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
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
    public String getUsername() {
        return username;
    }

    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " "+ this.getLastName()+" "+ this.getUsername() + " " + this.getEmail()+ " "+ this.getPassword();
    }
}
