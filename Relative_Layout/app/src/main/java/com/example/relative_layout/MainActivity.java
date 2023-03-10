package com.example.relative_layout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
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
    private Spinner spPrograms;
    private String text;
    private String program;
    private Intent change;
    private AlertDialog.Builder alert;
    private TextView tvChannel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnChange = findViewById(R.id.bnChanges);
        EditText etChannel = findViewById(R.id.etChannel);

        tvChannel = findViewById(R.id.tvChannel);
        spPrograms = findViewById(R.id.spPrograms);
        ivContinued = findViewById(R.id.ivContinued);

        //Cambiar color desde codigo
        //tvChannel.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));

        spPrograms.setOnItemSelectedListener(this);
        bnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text = etChannel.getText().toString();
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
                intent();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        program = adapterView.getItemAtPosition(i).toString();
        Snackbar.make(adapterView, "Programa Seleccionado: " + program, Snackbar.LENGTH_LONG).show();

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
    private void intent() {
        final CharSequence[] options = {"Ok", "Cancelar"};
        alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Estas seguro de cambiar de pantalla?");
        alert.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (options[i].equals("Ok")) {
                    change = new Intent(MainActivity.this, SecondActivity.class);
                    text = tvChannel.getText().toString();
                    change.putExtra("Programa", program);
                    change.putExtra("Canal", text);
                    startActivity(change);
                } else {
                    dialogInterface.dismiss();
                }

            }
        });
        alert.show();

    }
}