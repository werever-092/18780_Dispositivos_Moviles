package edu.iest.examen_2parcial.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {
    private val URL_BASE = "https://api.thecatapi.com/V1/"
    fun createAPIService(): InterfaceAPI {
        val retrofit = Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        val service: InterfaceAPI = retrofit.create(InterfaceAPI::class.java)
        return service
    }
}