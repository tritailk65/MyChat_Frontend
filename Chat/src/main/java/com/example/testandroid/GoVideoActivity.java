package com.example.testandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GoVideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_call_activity);
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