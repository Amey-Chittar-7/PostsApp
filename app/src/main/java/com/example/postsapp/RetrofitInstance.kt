package com.example.postsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //URL: https://jsonplaceholder.typicode.com/posts
    val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun provideApiService():ApiService{
        return retrofit.create(ApiService::class.java)
    }

}

