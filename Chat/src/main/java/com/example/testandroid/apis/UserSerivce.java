package com.example.testandroid.apis;

import com.example.testandroid.models.UserModel;
import java.util.UUID;
import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserSerivce {
    @GET("GetByID")
    Call<UserModel> GetUserByID(UUID id);
}
