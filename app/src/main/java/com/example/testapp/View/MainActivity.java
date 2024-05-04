package com.example.testapp.View;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.testapp.databinding.ActivityMainBinding;
import com.example.testapp.repository.MainRepo;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.RequestCallback;

import java.security.Permission;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding views;

    private MainRepo mainRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        views = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(views.getRoot());
        init();
    }

    private void init() {
        mainRepository = MainRepo.getInstance();
        views.btnSignin.setOnClickListener(v -> {
            PermissionX.init(this)
                    .permissions(android.Manifest.permission.CAMERA, android.Manifest.permission.RECORD_AUDIO)
                    .request((allGranted, grantedList, deniedList) -> {
                        if (allGranted) {
                            //login to firebase here

                            mainRepository.login(
                                    views.username.getText().toString(), getApplicationContext(), () -> {
                                        //if success then we want to move to call activity
                                        startActivity(new Intent(MainActivity.this, CallActivity.class));
                                    }
                            );
                        }
                    });


        });
    }
}