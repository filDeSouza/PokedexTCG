package com.example.pokedextcg.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitService {

    var BASE_URL: String = "https://api.pokemontcg.io/v2/"
    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit? {

        if (retrofit == null) {

            val httpClient = OkHttpClient.Builder()
                httpClient.readTimeout(30, TimeUnit.SECONDS)
                httpClient.connectTimeout(30, TimeUnit.SECONDS)
                httpClient.writeTimeout(30, TimeUnit.SECONDS)

            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addInterceptor(httpLoggingInterceptor)

            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
        }
        return retrofit


    }


    fun getApiService(): PokeTcgAPI{
        return getRetrofit()!!.create(PokeTcgAPI::class.java)
    }

}