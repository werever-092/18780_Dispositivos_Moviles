package edu.iest.buttoms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tvFrase : TextView
        tvFrase = findViewById(R.id.tvfrase)
        var etFrase : EditText
        etFrase = findViewById(R.id.editTextFrase)
        var bnShow = findViewById<Button>(R.id.mostrar)
        bnShow.setOnClickListener{
            var Frase = etFrase.text.toString()
            Snackbar.make(tvFrase, "Su frase fue: $Frase", Snackbar.LENGTH_LONG).show()
        }
    }
}