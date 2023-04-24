package com.example.games

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    private lateinit var tvWelcome: TextView
    private lateinit var etName: EditText
    private lateinit var etnAge: EditText
    private lateinit var etHeight: EditText
    private lateinit var etWallet: EditText
    private lateinit var bnSave: Button
    private lateinit var switchPrefs: Switch
    private val NAME_KEY = "nombre"
    private val AGE_KEY = "edad"
    private val HEIGHT_KEY = "altura"
    private val WALLET_KEY = "monedero"
    private val SWITCH_KEY = "switch_estado"
    private val NAME_INSTANCE = "nombre_instancia"
    private var name: String = ""
    private var age: Int = 0
    private var height: Float = 0.0f
    private var wallet: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PREFERENCIAS", "onCreate")
        setContentView(R.layout.activity_main)

        var actionBar: ActionBar?
        actionBar = supportActionBar
        var colorDrawable: ColorDrawable
        colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionBar!!.setBackgroundDrawable(colorDrawable)

        inicializarVistas()

        Log.d("PREFERENCIAS", savedInstanceState?.getString(NAME_KEY).toString())
//nombre = savedInstanceState?.getString(NOMBRE_KEY).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PREFERENCIAS", "onSaveInstanceState")
        outState.putString(NAME_KEY, name )
        outState.putInt(AGE_KEY, age )
        outState.putFloat(HEIGHT_KEY, height )
        outState.putFloat(WALLET_KEY, wallet )
        outState?.run {
            putString(NAME_KEY, name)
            putInt(AGE_KEY, age)
            putFloat(HEIGHT_KEY, height)
            putFloat(WALLET_KEY, wallet)
        }
// call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)

    }

    override fun onResume() {
        Log.d("PREFERENCIAS", "onResume")
        if(TextUtils.isEmpty(name)){
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            name = miSharedPreferences.getString(NAME_KEY, "").toString()
            age = miSharedPreferences.getInt(AGE_KEY, 0)
            height = miSharedPreferences.getFloat(HEIGHT_KEY, 0.0f)
            wallet = miSharedPreferences.getFloat(WALLET_KEY, 0.0f)
        }

        tvWelcome.text = name
        super.onResume()
    }

    override fun onStart() {
        Log.d("PREFERENCIAS", "onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d("PREFERENCIAS", "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("PREFERENCIAS", "onDestroy")
        super.onDestroy()
    }

    private fun cambiarTextoBienvenida(nombre: String) {
        if (!TextUtils.isEmpty(nombre)) {
            tvWelcome.text = "Bienvenido " + nombre
        }
    }

    private fun inicializarVistas() {
        tvWelcome = findViewById(R.id.tvWelcome)
        etName = findViewById(R.id.etName)
        bnSave = findViewById(R.id.bnSave)
        switchPrefs = findViewById(R.id.swPref)
        etnAge = findViewById(R.id.etAge)
        etHeight = findViewById(R.id.etHeight)
        etWallet = findViewById(R.id.etWallet)

        bnSave.setOnClickListener {
            name = etName.text.toString()
            age = etnAge.text.toString().toInt()
            height = etHeight.text.toString().toFloat()
            wallet = etWallet.text.toString().toFloat()
            cambiarTextoBienvenida(name)
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            val editor = miSharedPreferences.edit()
            editor.putString(NAME_KEY, name)
            editor.putInt(AGE_KEY, age)
            editor.putFloat(HEIGHT_KEY, height)
            editor.putFloat(WALLET_KEY, wallet)
            editor.apply()
            val s = Intent(this, GameList::class.java)
            startActivity(s)
            finish()
        }

    }
}