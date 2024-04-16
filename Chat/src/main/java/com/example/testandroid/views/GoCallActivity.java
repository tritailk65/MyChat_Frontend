package com.example.testandroid.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testandroid.R;

public class GoCallActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_call_activity);
//        TextView backCall= findViewById(R.id.backCall);
//        backCall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GoCallActivity.this, ChatActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
