package com.example.testandroid.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testandroid.apis.AuthenticateService;
import com.example.testandroid.apis.UserSerivce;
import com.example.testandroid.models.AuthRequest;
import com.example.testandroid.models.AuthResponse;
import com.example.testandroid.models.UserModel;
import com.example.testandroid.util.AuthInterceptor;
import com.example.testandroid.util.TokenManager;

import java.util.UUID;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {
    private Context context;
    public static final String AUTH_API = "/api/User/";
    private MutableLiveData<UserModel> userModelMutableLiveData;
    public UserSerivce userSerivce;

    public void setContextRepo(Context context) {
        this.context = context;
    }

    public UserRepository() {
        userModelMutableLiveData = new MutableLiveData<>();
        String token = TokenManager.getToken(context);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new AuthInterceptor(token)).build();

        userSerivce = new retrofit2.Retrofit.Builder()
                .baseUrl(AUTH_API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserSerivce.class);
    }

    public void GetUserInfo(UUID id) {
        userSerivce.GetUserByID(id)
                .enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        if (response.isSuccessful()) {

                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {

                    }
                });
    }

    public LiveData<UserModel> getUserInfoLiveData(){
        return userModelMutableLiveData;
    }

}
