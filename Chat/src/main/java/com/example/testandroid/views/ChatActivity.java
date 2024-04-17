package com.example.testandroid.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.testandroid.R;
import com.example.testandroid.databinding.ActivityMainBinding;
import com.example.testandroid.viewmodels.SettingViewModel;

public class ChatActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hiden title bar
        getSupportActionBar().hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ChatFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.ChatList:
                    ChatFragment chatFragment=new ChatFragment();
                    replaceFragment(chatFragment);
                    break;
                case  R.id.CallList:
                    replaceFragment(new CallFragment());
                    break;
                case R.id.Communication:
                    replaceFragment(new CommunicationFragment());
                    break;
                case R.id.Setting:
                    SettingFragment settingFragment=new SettingFragment();
                    replaceFragment(settingFragment);
                    break;
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Constraint_layout,fragment);
        fragmentTransaction.commit();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            // Xử lý hình ảnh đã chọn ở đây
        }
    }
}
