package com.example.equalityjob.network

import com.example.equalityjob.utils.LoginDataStorage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.15.84:5137"
    val instance: EQualityJobApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EQualityJobApi::class.java)
    }

    fun buildAuthHeader(): String {
        val token = LoginDataStorage.getToken()
        return "Bearer $token"
    }
}