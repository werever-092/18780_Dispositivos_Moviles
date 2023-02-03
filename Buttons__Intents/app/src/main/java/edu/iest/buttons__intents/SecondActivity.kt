package edu.iest.buttons__intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var iRec = intent.getStringExtra("Score")
        val tvScore = findViewById<TextView>(R.id.tvFscore)
        tvScore.text = "Felicidades Aprobaste la materia con $iRec"

        var bnBack = findViewById<Button>(R.id.bnBack)
        bnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity :: class.java))
            finish()
        }
    }
}