package com.example.api.network

import com.example.api.models.Breed
import com.example.api.models.ImageBreed
import com.example.api.models.ImageRandom
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

        @GET("breeds/image/random")
        fun RandomImage():
                Call<ImageRandom>

        @GET("breed/{raza}/images")
        fun listImagesBreeds
                        (@Path("raza") raza: String):
                Call<ImageBreed>

        @GET("breed/hound/list")
        fun allBreeds() : Call<Breed>
}