package com.example.retrofitemployeemanagement.model

data class Employee(
    var id: Int = 0,
    val firstName: String,
    val lastName: String,
    val designation: String,
    val department: String,
    val address: String,
)