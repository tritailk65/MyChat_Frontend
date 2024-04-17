package com.example.testandroid.viewmodels;



import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.LiveData;

import com.example.testandroid.repositories.AuthRepository;


public class SettingViewModel extends BaseObservable {
    private Context context;
    private LiveData<Boolean> isAuthLiveData = new LiveData<Boolean>() {};
    private String toastMessage = null;
    private AuthRepository authRepository;

    public void init(){
        authRepository = new AuthRepository();
        isAuthLiveData = authRepository.getIsAuthenticateSuccess();
    }
    public void setContextViewModel(Context context){
        this.context = context;
    }
    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void onButtonClickedLogOut() {
        if (true)
            setToastMessage("Đăng xuất thành công");
        else
            setToastMessage("Đăng xuất thất bại");
    }


    public LiveData<Boolean> getIsLoggedOut(){
        return isAuthLiveData;
    }
}
