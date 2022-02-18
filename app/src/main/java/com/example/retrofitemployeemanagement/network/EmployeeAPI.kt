package com.example.retrofitemployeemanagement.network

import com.example.retrofitemployeemanagement.model.Employee
import retrofit2.Response
import retrofit2.http.*

interface EmployeeAPI {

    @GET("/employees")
    suspend fun getAllEmployees(): List<Employee>

    @GET("/employees/{id}")
    suspend fun getEmployee(@Path("id") id: Int) : Response<Employee>

    @POST("/employees")
    suspend fun addEmployee(@Body employee: Employee): Response<Employee>

    @PUT("/employees/{id}")
    suspend fun updateEmployee(@Path("id") id: Int, @Body employee: Employee): Response<Employee>

    @DELETE("/employees/{id}")
    suspend fun deleteEmployee(@Path("id") id: Int): Response<Unit>
}