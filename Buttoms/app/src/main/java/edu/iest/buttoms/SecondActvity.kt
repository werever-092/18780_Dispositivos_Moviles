package edu.iest.buttoms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class SecondActvity : AppCompatActivity(), View.OnClickListener {
    private var cambioIcon : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_actvity)
        var fraseRec = intent.getStringExtra("Frase")
        var edadRec = intent.getIntExtra("Edad", 0)

        var GoToScreen = findViewById<Button>(R.id.showscreen)
        var img = findViewById<ImageView>(R.id.ivIest)
        //var img_2 = false
        img.setOnClickListener {
            var arrayIcon = arrayOf<Int>(R.drawable.iest, R.drawable.a)
            if (cambioIcon) {
                img.setImageResource(arrayIcon[0])
            } else {
                img.setImageResource(arrayIcon[1])
            }
            cambioIcon = !cambioIcon

            /*if (img_2 == false) {
                img.setImageResource(R.drawable.a)
                img_2 = true
            } else {
                img.setImageResource(R.drawable.iest)
                img_2 = false
            }*/

        }

        Log.d("Datos", "Datos recibidos con exito, fueron $fraseRec y edad $edadRec")
        GoToScreen.setOnClickListener {
            val i = Intent(this, MainActivity :: class.java)
            startActivity(i)
            finish()
        }

        var bnClose = findViewById<Button>(R.id.close)
        bnClose.setOnClickListener {
            finish()
        }

        bnClose.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}