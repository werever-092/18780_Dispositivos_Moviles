package com.example.ex_p1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView ivMovie;
    private Spinner spSched;
    private String text;
    private String movie;
    private Intent change;
    private AlertDialog.Builder alert;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bnChange = findViewById(R.id.bnChange);

        tvTitle = findViewById(R.id.tvTitle);
        spSched = findViewById(R.id.spSched);
        ivMovie = findViewById(R.id.ivMovie;

        //Cambiar color desde codigo
        //tvChannel.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));

        spSched.setOnItemSelectedListener(this);
        bnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text = .getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Escribe en la parte de arriba", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "El valor era " + text, Toast.LENGTH_SHORT).show();
                    tvChannel.setText(text);
                }
            }
        });

        ivMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        movie = adapterView.getItemAtPosition(i).toString();
        Snackbar.make(adapterView, "Programa Seleccionado: " + movie, Snackbar.LENGTH_LONG).show();

        if (i == 0) {
            ivMovie.setImageResource(R.drawable.unnamed);
        } else {
            ivMovie.setImageResource(R.drawable.diasdetruenolarge);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void intent() {
        final CharSequence[] options = {"Ok", "Cancelar"};
        alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Estas seguro de comprar los boletos?");
        alert.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (options[i].equals("Ok")) {
                    change = new Intent(MainActivity.this, SecondActivity.class);
                    text = tvTitle.getText().toString();
                    change.putExtra("Programa", movie);
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
}