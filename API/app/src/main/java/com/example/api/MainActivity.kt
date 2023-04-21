package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.api.models.Breed
import com.example.api.models.ImageBreed
import com.example.api.models.ImageRandom
import com.example.api.network.API
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val apiCall = API().createAPIService()

    private lateinit var tvZelda: TextView
    private lateinit var ivPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvZelda = findViewById(R.id.tvZelda)
        ivPhoto = findViewById(R.id.ivPhoto)


        breedImage()
        Breed()

    }

    private fun breedImage() {

        apiCall.listImagesBreeds("hound").enqueue(object: Callback<ImageBreed> {
            override fun onResponse(call: Call<ImageBreed>, response: Response<ImageBreed>) {
                val dogs = response.body()?.message
                Log.d("PRUEBAS", "Status de la respuesta ${response.body()?.status}")
                if (dogs != null) {
                    for (dog in dogs) {
                        Log.d("PRUEBAS", "Perro es $dog")
                    }
                }
            }

            override fun onFailure(call: Call<ImageBreed>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "No fue posible conectar a API_2",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }
    private fun randomImage() {

        apiCall.RandomImage().enqueue(object : Callback<ImageRandom> {
            override fun onResponse(call: Call<ImageRandom>, response: Response<ImageRandom>) {
                Log.d("API_PRUEBA", "status es " + response.body()?.status)
                Log.d("API_PRUEBA ", "message es " + response.body()?.message)
                // Aqui hacer lo que necesitemos con los datos
                val status = response.body()?.status
                if (status == "success") {
                    tvZelda.text = response.body()?.message
                    Picasso.get().load(response.body()?.message).into(ivPhoto)
                } else {
                    Snackbar.make(ivPhoto, "Success false", Snackbar.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ImageRandom>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "No fue posible conectar a API",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun Breed() {

        apiCall.allBreeds().enqueue(object : Callback<Breed> {
            override fun onResponse(call: Call<Breed>, response: Response<Breed>) {
                Log.d("PRUEBAS", "status Razaxs es " + response.body()?.status)

                Log.d("PRUEBAS", "message es " + response.body()?.message)
                var dogs = response.body()?.message?.hound

                if (dogs != null) {
                    for (dog in dogs) {
                        Log.d("PRUEBAS", "perro es " + dog)
                    }
                }


            }

            override fun onFailure(call: Call<Breed>, t: Throwable) {
                Log.d("PRUEBAS", "message es " + t.toString())
                Toast.makeText(
                    this@MainActivity,
                    "No fue posible conectar a API 2",
                    Toast.LENGTH_SHORT
                ).show()

            }


        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_images, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.optMenuListIMG) {
            Toast.makeText(this, "OPTION menu 1", Toast.LENGTH_SHORT).show()
            randomImage()
        }
        return super.onOptionsItemSelected(item)
    }
}