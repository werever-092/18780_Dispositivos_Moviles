package edu.iest.buttoms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_actvity)
        var GoToScreen = findViewById<Button>(R.id.showscreen)
        GoToScreen.setOnClickListener {
            val i = Intent(this, MainActivity :: class.java)
            startActivity(i)
        }

    }
}