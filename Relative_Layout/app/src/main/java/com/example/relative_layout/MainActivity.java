package com.example.relative_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView ivContinued;
    private Intent change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnChange = findViewById(R.id.bnChanges);
        EditText etChannel = findViewById(R.id.etChannel);
        TextView tvChannel = findViewById(R.id.tvChannel);

        Spinner spPrograms = findViewById(R.id.spPrograms);
        ivContinued = findViewById(R.id.ivContinued);

        spPrograms.setOnItemSelectedListener(this);
        bnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = etChannel.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Escribe en la parte de arriba", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "El valor era " + text, Toast.LENGTH_SHORT).show();
                    tvChannel.setText(text);
                }
            }
        });

        ivContinued.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(change);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String program = adapterView.getItemAtPosition(i).toString();
        Snackbar.make(adapterView, "Programa Seleccionado" + program, Snackbar.LENGTH_LONG).show();

        if (i == 0) {
            ivContinued.setImageResource(R.drawable.backtofuturetbc);
        } else if (i == 1) {
            ivContinued.setImageResource(R.drawable.tobecontinued);
        } else {
            ivContinued.setImageResource(R.drawable.thatsallfolks);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}