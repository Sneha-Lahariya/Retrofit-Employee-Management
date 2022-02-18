package com.example.retrofitemployeemanagement.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://intense-hamlet-21058.herokuapp.com"

    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val employeeAPI:EmployeeAPI by lazy {
        retrofit.build().create(EmployeeAPI::class.java)
    }
}