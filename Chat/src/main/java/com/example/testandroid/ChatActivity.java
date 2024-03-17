package com.example.testandroid;

import android.os.Bundle;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ChatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chats);
        LinearLayout menu= findViewById(R.id.menu_layout);
        ConstraintLayout chats= findViewById(R.id.chats_layout);
        if (menu != null) {
           chats.addView(menu);
        } else {

        }
    }
}
