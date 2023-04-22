package edu.iest.examen_2parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import edu.iest.examen_2parcial.models.Cat
import edu.iest.examen_2parcial.network.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatActivity : AppCompatActivity() {

    val apiCall = API().createAPIService()
    val tvZelda = findViewById<TextView>(R.id.tvZelda)
    val ivPhoto = findViewById<ImageView>(R.id.ivPhoto)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat)

        apiCall.catImage().enqueue(object : Callback<Cat> {
            override fun onResponse(call: Call<Cat>, response: Response<Cat>) {
                Log.d("API_PRUEBA", "id es " + response.body()?.id)
                Log.d("API_PRUEBA", "url es " + response.body()?.url)
                Log.d("API_PRUEBA", "ancho es " + response.body()?.width)
                Log.d("API_PRUEBA", "altura es " + response.body()?.height)
                val status = response.body()?.id
                if (status == "0XYvRd7oD") {
                    tvZelda.text = response.body()?.id
                    Picasso.get().load(response.body()?.url).into(ivPhoto)
                } else {
                    Snackbar.make(ivPhoto, "Success false", Snackbar.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Cat>, t: Throwable) {
                Toast.makeText(
                    this@CatActivity, "No fue posible conectar a API",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}