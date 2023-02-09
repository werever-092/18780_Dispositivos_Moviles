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
    private var etFirstNum : EditText? = null
    private var etSecondNum : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startViews()
        eventAssing()
    }

    private fun startViews() {
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
        etFirstNum = findViewById(R.id.etFirstNum)
        etSecondNum = findViewById(R.id.etSecondNum)
    }

    private fun eventAssing() {
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        //Entrara los clicks de las vistas
        val firstNum = etFirstNum?.text.toString().toFloatOrNull()
        val secondNum = etSecondNum?.text.toString().toFloatOrNull()
        val arit = Aritmetica()
        when(p0?.id) {
            R.id.bnSuma -> {
                if (firstNum != null && secondNum != null) {
                    val plus = arit.plus(firstNum, secondNum)
                    val msg = Mensajes("La suma es $plus", this@MainActivity)
                    msg.showToast()
                } else {
                    Toast.makeText(this, "No asignaste ningun número", Toast.LENGTH_LONG).show()

                }
            }
            R.id.bnResta -> {
                if (firstNum != null && secondNum != null) {
                    val minus = arit.plus(firstNum, secondNum)
                    Snackbar.make(p0, "El resultado de la resta es $minus", Snackbar.LENGTH_LONG).show()
                } else {
                    Snackbar.make(p0, "No asignaste ninun número", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}