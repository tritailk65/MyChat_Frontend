package com.example.testandroid.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testandroid.databinding.FirebaseLoginBinding;
import com.example.testandroid.repositories.FirebaseRepository;
import com.permissionx.guolindev.PermissionX;

public class FirebaseLoginActivity extends AppCompatActivity {
    private FirebaseLoginBinding views;

    private FirebaseRepository mainRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        views = FirebaseLoginBinding.inflate(getLayoutInflater());
        setContentView(views.getRoot());
        init();
    }

    private void init() {
        mainRepository = FirebaseRepository.getInstance();
        views.enterBtn.setOnClickListener(v -> {
            PermissionX.init(this)
                    .permissions(android.Manifest.permission.CAMERA, android.Manifest.permission.RECORD_AUDIO)
                    .request((allGranted, grantedList, deniedList) -> {
                        if (allGranted) {
                            //login to firebase here

                            mainRepository.login(
                                    views.username.getText().toString(), getApplicationContext(), () -> {
                                        //if success then we want to move to call activity
                                        startActivity(new Intent(this, FirebaseCallActivity.class));
                                    }
                            );
                        }
                    });


        });
    }
}
