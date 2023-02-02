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
            if (getScore() < 6.9) {
                var i = Intent(this, ThirdActivity :: class.java)
                i.putExtra("Score", getScore())
                startActivity(i)
                finish()
            } else {
                var i = Intent(this, SecondActivity :: class.java)
                i.putExtra("Score", getScore())
                startActivity(i)
                finish()
            }

        }
    }

    private fun getScore() : Float {
        return et_Score.text.toString().toFloat()
    }
}