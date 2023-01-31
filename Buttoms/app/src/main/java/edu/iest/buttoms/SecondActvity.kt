package edu.iest.buttoms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class SecondActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_actvity)
        var fraseRec = intent.getStringExtra("Frase")
        var edadRec = intent.getIntExtra("Edad", 0)
        var GoToScreen = findViewById<Button>(R.id.showscreen)
        var img = findViewById<ImageView>(R.id.ivIest)
        var img_2 = false
        img.setOnClickListener {
            if (img_2 == false) {
                img.setImageResource(R.drawable.a)
                img_2 = true
            } else {
                img.setImageResource(R.drawable.iest)
                img_2 = false
            }

        }
        Log.d("Datos", "Datos recibidos con exito, fueron $fraseRec y edad $edadRec")
        GoToScreen.setOnClickListener {
            val i = Intent(this, MainActivity :: class.java)
            startActivity(i)
            finish()
        }

        var bnClose = findViewById<Button>(R.id.close)
        bnClose.setOnClickListener {
            finish()
        }
    }
}