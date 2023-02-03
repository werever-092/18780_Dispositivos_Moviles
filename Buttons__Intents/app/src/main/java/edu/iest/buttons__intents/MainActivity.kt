package edu.iest.buttons__intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var et_Score : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_Score = findViewById(R.id.etScore)
        var bnScore = findViewById<Button>(R.id.bnSend)
        bnScore.setOnClickListener {
            if (getScore() <= "6.99") {
                startActivity(Intent(this, ThirdActivity :: class.java).putExtra("Score", getScore()))
                finish()
            } else {
                startActivity(Intent(this, SecondActivity :: class.java).putExtra("Score", getScore()))
                finish()
            }

        }
    }

    private fun getScore() : String {
        return et_Score.text.toString()
    }
}