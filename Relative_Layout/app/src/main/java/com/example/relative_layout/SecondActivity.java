package com.example.relative_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private String programs, channel;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvChannel = findViewById(R.id.tvChnl);
        TextView tvPrograms = findViewById(R.id.tvProgs);
        Button bnBack = findViewById(R.id.bnBack);

         programs = getIntent().getStringExtra("Programa");
         channel = getIntent().getStringExtra("Canal");

         tvChannel.setText(channel);
         tvPrograms.setText(programs);

         bnBack.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 i = new Intent(SecondActivity.this, MainActivity.class);
                 startActivity(i);
             }
         });
    }
}