package com.example.testandroid.apis;

import com.example.testandroid.models.APIResponse;
import com.example.testandroid.models.AuthRequest;
import com.example.testandroid.models.AuthResponse;
import com.example.testandroid.models.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticateService {
    @POST("api/User/Authenticate")
    Call<AuthResponse> Authenticate(@Body AuthRequest authenticateRequest);
    @POST("api/User/")
    Call<APIResponse> SignUp (@Body UserModel userModel);
}
