package com.example.testandroid.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.testandroid.R;
import com.example.testandroid.databinding.SignupBinding;
import com.example.testandroid.viewmodels.SignUpViewModel;

public class SignUpActivity extends AppCompatActivity {
    private SignUpViewModel signUpViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        SignupBinding signupBinding = DataBindingUtil.setContentView(this,R.layout.signup);
        signUpViewModel = new SignUpViewModel();

        signupBinding.setSignUp(signUpViewModel);
        signupBinding.executePendingBindings();

        signUpViewModel.getIsSignIn().observe(this, isSignIn ->{
            if(isSignIn){
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUpViewModel.getErrorSignIn().observe(this, errorSignIn -> {
            if(errorSignIn != null && errorSignIn != ""){
                Toast
                        .makeText(getApplicationContext(), errorSignIn,
                                Toast.LENGTH_SHORT)
                        .show();
            }
        });

        ImageView back= findViewById(R.id.goBack);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    @BindingAdapter({ "toastMessage" })
    public static void runMe(View view, String message)
    {
        if (message != null)
            Toast
                    .makeText(view.getContext(), message,
                            Toast.LENGTH_SHORT)
                    .show();
    }
}
