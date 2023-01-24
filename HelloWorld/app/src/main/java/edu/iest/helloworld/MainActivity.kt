package edu.iest.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var tvGreeting: TextView //lateinit solo para var global de vistas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvGreeting = findViewById(R.id.tvhi)
        //tvGreeting.text = "Bienvenudos"
        cambiarMensaje()


    }

    private fun cambiarMensaje(){
        val mensaje_original:String
        mensaje_original = tvGreeting.toString()
        Toast.makeText(this,"Tu mensaje era " + mensaje_original + ":)", Toast.LENGTH_LONG).show()
    }

    private fun cambiarMensaje(){

    }
}