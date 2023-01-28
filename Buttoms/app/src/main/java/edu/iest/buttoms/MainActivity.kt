package edu.iest.buttoms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var tvFrase : TextView
    private lateinit var etFrase : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvFrase = findViewById(R.id.tvfrase)
        etFrase = findViewById(R.id.editTextFrase)
        var bnShow = findViewById<Button>(R.id.mostrar)
        bnShow.setOnClickListener{
            var Frase = getFrase()
            Snackbar.make(tvFrase, "Su frase fue: $Frase", Snackbar.LENGTH_LONG).show()
        }

        var bnNext = findViewById<Button>(R.id.next)
        bnNext.setOnClickListener{
            var i = Intent(this, SecondActvity :: class.java)
            i.putExtra("Frase", getFrase())
            i.putExtra("Edad", 22)
            startActivity(i)
            finish()
            }
        }
    private fun getFrase() : String{
        return etFrase.text.toString()
    }
}