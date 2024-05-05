package com.example.testandroid.viewmodels;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;

import com.example.testandroid.BR;
import com.example.testandroid.models.UserModel;
import com.example.testandroid.repositories.AuthRepository;

public class SignUpViewModel extends BaseObservable {
    private UserModel userModel ;
    private AuthRepository authRepository;
    private LiveData<Boolean> isSignUpSuccess;
    private LiveData<String> authErrorMessage;

    public LiveData<Boolean> getIsSignIn() {return isSignUpSuccess;}
    public LiveData<String> getErrorSignIn() {return  authErrorMessage;}

    public SignUpViewModel(){
        userModel = new UserModel("","","","","");
        authRepository = new AuthRepository();
        authErrorMessage = authRepository.getErrorMessage();
        isSignUpSuccess = authRepository.getIsSignUpSuccess();
    }

    private String errorMessage = "Email or password is not valid";

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
    @Bindable
    public String getSUEmail() {
        return userModel.getEmail();
    }

    public void setSUEmail(String email) {
        userModel.setEmail(email);
        notifyPropertyChanged(BR.sUEmail);
    }

    @Bindable
    public String getSUFirstName() {
        return userModel.getFirstName();
    }

    public void setSUFirstName(String firstName) {
        userModel.setFirstName(firstName);
        notifyPropertyChanged(BR.sUFirstName);
    }

    @Bindable
    public String getSUPassword() {
        return userModel.getPassword();
    }

    public void setSUPassword(String password) {
        userModel.setPassword(password);
        notifyPropertyChanged(BR.sUPassword);
    }

    @Bindable
    public String getSULastName() {
        return userModel.getLastName();
    }

    public void setSULastName(String lastName) {
        userModel.setLastName(lastName);
        notifyPropertyChanged(BR.sULastName);
    }

    @Bindable
    public String getSUUserName() {return  userModel.getUsername();}

    public void setSUUserName(String userName){
        userModel.setUsername(userName);
        notifyPropertyChanged(BR.sUUserName);
    }

    public void onButtonClicked() {
        if (isValid()){
            UserModel userModel = new UserModel();
            userModel.setFirstName(getSUFirstName());
            userModel.setLastName(getSULastName());
            userModel.setPassword(getSUPassword());
            userModel.setEmail(getSUEmail());
            userModel.setUsername(getSUUserName());
            authRepository.SignUp(userModel);
        }
        else{
            setToastMessage(errorMessage);
        }

    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getSUEmail()) && Patterns.EMAIL_ADDRESS.matcher(getSUEmail()).matches()
                && getSUPassword().length() > 6;
    }
}
