package com.hitta.android.assignment.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private var instance: Retrofit? = null

    fun getInstance(url: String): Retrofit =
            instance ?: Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().apply { instance = this }
}