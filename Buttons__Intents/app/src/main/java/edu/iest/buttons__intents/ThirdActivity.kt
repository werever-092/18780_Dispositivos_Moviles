package edu.iest.buttons__intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var iRec = intent.getStringExtra("Score")
        val tvScore = findViewById<TextView>(R.id.tvFail)
        tvScore.text = "Obtuviste un $iRec :,("

        var bnAgain = findViewById<Button>(R.id.bnAgain)
        bnAgain.setOnClickListener {
            startActivity(Intent(this, MainActivity :: class.java))
            finish()
        }
    }
}