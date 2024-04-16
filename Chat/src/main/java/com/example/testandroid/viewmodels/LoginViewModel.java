package com.example.testandroid.viewmodels;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testandroid.BR;
import com.example.testandroid.models.AuthRequest;
import com.example.testandroid.models.UserModel;
import com.example.testandroid.repositories.AuthRepository;
import com.example.testandroid.util.TokenManager;

public class LoginViewModel extends BaseObservable {
    private UserModel userModel;
    private Context context;
    private AuthRepository authRepository;
    private LiveData<UserModel> userModelLiveData ;
    private LiveData<Boolean> isAuthLiveData = new LiveData<Boolean>() {};

    public void setContextViewModel(Context context){
        this.context = context;
    }

    public void init(){
        authRepository = new AuthRepository();
        isAuthLiveData = authRepository.getIsAuthenticateSuccess();
    }

    public LoginViewModel(){
        userModel = new UserModel("","");
    }

    private String successMessage = "Login success";
    private String errorMessage = "Email or password is not valid";
    private String loginFailMessage = "Email or password isn't correct";

    // string variable for toast message
    @Bindable
    private String toastMessage = null;

    // getter and setter methods for toast message
    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    // getter and setter methods
    // for email variable
    @Bindable
    public String getUserEmail() {
        return userModel.getEmail();
    }

    public void setUserEmail(String email) {
        userModel.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    // getter and setter methods
    // for password variable
    @Bindable
    public String getUserPassword() {
        return userModel.getPassword();
    }

    public void setUserPassword(String password) {
        userModel.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LiveData<Boolean> getIsLoggedIn(){
        return isAuthLiveData;
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    public void onButtonClicked() {
        if (isValid()){
            AuthRequest authRequest = new AuthRequest();
            authRequest.setEmail(getUserEmail());
            authRequest.setPassword(getUserPassword());
            authRepository.setContextRepo(context);
            authRepository.Authenticate(authRequest);
            if(authRepository.getIsAuthenticateSuccess().getValue() == false){
                setToastMessage(loginFailMessage);
            }
        }
        else
            setToastMessage(errorMessage);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 6;
    }

}
