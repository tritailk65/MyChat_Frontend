package com.example.testandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class ChatBoxActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbox);
        AppCompatImageView btnBack= findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatBoxActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
        ImageView goCall=findViewById(R.id.goCall);
        goCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatBoxActivity.this, GoCallActivity.class);
                startActivity(intent);
            }
        });
        ImageView goCamera=findViewById(R.id.goCamera);
        goCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatBoxActivity.this, GoVideoActivity.class);
                startActivity(intent);
            }
        });
    }
}
