package com.example.testandroid.views;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.testandroid.R;
import com.example.testandroid.databinding.ActivityMainBinding;

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
            int itemId = item.getItemId();

            if (itemId == R.id.ChatList) {
                ChatFragment chatFragment = new ChatFragment();
                replaceFragment(chatFragment);
            } else if (itemId == R.id.CallList) {
                replaceFragment(new CallFragment());
            } else if (itemId == R.id.Communication) {
                replaceFragment(new CommunicationFragment());
            } else if (itemId == R.id.Setting) {
                replaceFragment(new SettingFragment());
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

}
