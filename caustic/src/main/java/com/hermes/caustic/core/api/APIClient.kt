package com.hermes.caustic.core.api

import com.hermes.caustic.core.api.services.APIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient{
    private const val BASE_URL = "https://api.tryhermes.app/api/v1/"

    private val httpClient : OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request()
        .newBuilder()
        .addHeader("origin", "*")
        .addHeader("Content-Type", "application/json")
        .build()
        chain.proceed(request)
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object APIClient {
    val apiService: APIService by lazy {
        RetrofitClient.retrofit.create(APIService::class.java)
    }

}

