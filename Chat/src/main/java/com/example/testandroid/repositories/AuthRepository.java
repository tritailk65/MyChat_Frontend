package com.example.testandroid.repositories;
import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.testandroid.apis.AuthenticateService;
import com.example.testandroid.models.AuthRequest;
import com.example.testandroid.models.AuthResponse;
import com.example.testandroid.util.TokenManager;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthRepository {
    Context context;
    public static final String AUTH_API = "http://192.168.0.103:81/api/User/";
    public AuthenticateService userService;
    public MutableLiveData<Boolean> isAuthenticateSuccess ;
    public MutableLiveData<Boolean> isLogOut ;
    public AuthRepository() {
        isAuthenticateSuccess = new MutableLiveData<Boolean>(false);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        userService = new retrofit2.Retrofit.Builder()
                .baseUrl(AUTH_API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthenticateService.class);
    }

    public void setContextRepo(Context context) {
        this.context = context;
    }

    public void Authenticate(AuthRequest request) {
        userService.Authenticate(request)
                .enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        AuthResponse authResponse  = response.body();
                        if (response.isSuccessful() && authResponse != null && authResponse.getToken() != null) {
                            //Lưu trữ JWT
                            String jwtToken = authResponse.getToken();
                            //Lưu mã token vào trong bộ nhớ trong
                            saveTokenToSharedPreferences(jwtToken);
                            isAuthenticateSuccess.postValue(true);
                        } else {
                            isAuthenticateSuccess.postValue(false);
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        isAuthenticateSuccess.postValue(false);
                    }
                });
    }

    private void saveTokenToSharedPreferences(String token) {
        // Lưu token
        TokenManager.saveToken(context,token);
    }

    public LiveData<Boolean> getIsAuthenticateSuccess(){
        return isAuthenticateSuccess;
    }

    public LiveData<Boolean> getIsLogOut(){
        isLogOut=new MutableLiveData<>(true);
        return isLogOut;
    }
}