package com.example.games

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SharedPreference : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        var tvName = findViewById<TextView>(R.id.tvName)
        var tvAge = findViewById<TextView>(R.id.tvAge)
        var tvHeight = findViewById<TextView>(R.id.tvHeight)
        var tvWallet = findViewById<TextView>(R.id.tvWallet)
        var bnBack = findViewById<Button>(R.id.bnBack)

        val sharedPreference = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE) ?: return
        val nombre = sharedPreference.getString("nombre", "")
        val edad = sharedPreference.getInt("edad", 0).toString()
        val altura = sharedPreference.getFloat("altura", 0.0f).toString()
        val monedero = sharedPreference.getFloat("monedero", 0.0f).toString()
        tvName.text = nombre
        tvAge.text = edad
        tvHeight.text = altura
        tvWallet.text = monedero

        bnBack.setOnClickListener{
            val s = Intent(this, GameList::class.java)
            startActivity(s)
            finish()
        }
    }
}