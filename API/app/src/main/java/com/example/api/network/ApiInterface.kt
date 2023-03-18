package com.example.api.network

import com.example.api.models.ImageRandom
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

        @GET("breeds/image/random")
        fun RandomImage(): Call<ImageRandom>
}