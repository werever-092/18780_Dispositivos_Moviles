package edu.iest.buttons__intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val iRec = intent.getStringExtra("Score")
        val tvScore = findViewById<TextView>(R.id.tvFscore)
        tvScore.setText("Score", "Felicidades Aprobaste con $iRec" )
    }
}