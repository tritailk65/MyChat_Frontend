package com.example.testandroid.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testandroid.R;
import com.example.testandroid.databinding.LoginBinding;
import com.example.testandroid.viewmodels.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hiden title bar
        getSupportActionBar().hide();

        LoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.login);
        viewModel = new LoginViewModel();
        viewModel.init();
        viewModel.setContextViewModel(getApplicationContext());
        loginBinding.setViewModel(viewModel);
        loginBinding.executePendingBindings();

        viewModel.getIsLoggedIn().observe(this, isLoggedIn ->{
            if(isLoggedIn){
                Intent intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TextView signup= findViewById(R.id.linksignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
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