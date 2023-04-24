package edu.iest.examen_2parcial.network

import edu.iest.examen_2parcial.models.Cat
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceAPI {
    @GET("images/0XYvRd7oD")
    fun catImage():
            Call<Cat>
}