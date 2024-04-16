package com.example.testandroid.apis;

import com.example.testandroid.models.AuthRequest;
import com.example.testandroid.models.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticateService {
    @POST("Authenticate")
    Call<AuthResponse> Authenticate(@Body AuthRequest authenticateRequest);
}
