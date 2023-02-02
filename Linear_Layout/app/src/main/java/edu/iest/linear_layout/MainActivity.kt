package edu.iest.linear_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var bnSuma : Button? = null
    private var bnResta : Button? = null
    private var etNumeroPrimero : EditText? = null
    private var etNumeroSegundo : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)

        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        //Entrara los clicks de las vistas
        when(p0?.id) {
            R.id.bnSuma -> {
                Toast.makeText(this, "Hice click en suma", Toast.LENGTH_LONG).show()
            }
            R.id.bnResta -> {
                Snackbar.make(p0, "Hice click en suma", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}