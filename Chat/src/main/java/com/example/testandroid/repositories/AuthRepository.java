package com.example.testandroid.repositories;
import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.testandroid.apis.AuthenticateService;
import com.example.testandroid.models.APIResponse;
import com.example.testandroid.models.AuthRequest;
import com.example.testandroid.models.AuthResponse;
import com.example.testandroid.models.UserModel;
import com.example.testandroid.util.TokenManager;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthRepository {
    Context context;
    public static final String AUTH_API = "http://192.168.0.103:81/";
    public AuthenticateService authenticateService;
    public MutableLiveData<Boolean> isAuthenticateSuccess = new MutableLiveData<>();
    public MutableLiveData<Boolean> isSignUpSuccess = new MutableLiveData<>(false);
    public MutableLiveData<String> errorMessage = new MutableLiveData<>("");
    public AuthRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        authenticateService = new retrofit2.Retrofit.Builder()
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
        authenticateService.Authenticate(request)
                .enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        AuthResponse authResponse  = response.body();
                        if (response.isSuccessful() ) {
//                            //Lưu trữ JWT
//                            String jwtToken = authResponse.getToken();
//                            //Lưu mã token vào trong bộ nhớ trong
//                            saveTokenToSharedPreferences(jwtToken);
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

    public void SignUp(UserModel userModel){
        authenticateService.SignUp(userModel)
                .enqueue(new Callback<APIResponse>() {
                    @Override
                    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                        if(response.isSuccessful()){
                            APIResponse apiResponse = response.body();
                            errorMessage.postValue(apiResponse.getMessage());
                            isSignUpSuccess.postValue(true);
                        } else {
                            // Khi phản hồi không thành công, chúng ta có thể lấy dữ liệu từ ResponseBody
                            ResponseBody errorBody = response.errorBody();
                            if (errorBody != null) {
                                try {
                                    Gson gson = new Gson();
                                    String e = errorBody.string(); // Lấy dữ liệu lỗi dưới dạng chuỗi
                                    //Chuyển đổi errorMessage thành một class đã được gán Serialize
                                    APIResponse apiResponse = gson.fromJson(e,APIResponse.class);
                                    Log.i("Message",apiResponse.getMessage());
                                    errorMessage.postValue(apiResponse.getMessage());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            isSignUpSuccess.postValue(false); // Đăng ký không thành công
                        }
                    }
                    @Override
                    public void onFailure(Call<APIResponse> call, Throwable t) {
                        isSignUpSuccess.postValue(false);
                    }
                });
    }

    private void saveTokenToSharedPreferences(String token) {
        // Lưu token
        TokenManager.saveToken(context,token);
    }

    public LiveData<Boolean> getIsSignUpSuccess(){
        return isSignUpSuccess;
    }

    public LiveData<Boolean> getIsAuthenticateSuccess(){
        return isAuthenticateSuccess;
    }

    public LiveData<String> getErrorMessage(){
        return errorMessage;
    }
}