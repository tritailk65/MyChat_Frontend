package com.example.testandroid.apis;

import com.example.testandroid.models.AuthRequest;
import com.example.testandroid.models.AuthResponse;
import com.example.testandroid.models.UpdateNameResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface AuthenticateService {
    @POST("Authenticate")
    Call<AuthResponse> Authenticate(@Body AuthRequest authenticateRequest);
    @PUT("Update") //
    Call<UpdateNameResponse> updateName(@Body UpdateNameResponse updateNameResponse);
}
