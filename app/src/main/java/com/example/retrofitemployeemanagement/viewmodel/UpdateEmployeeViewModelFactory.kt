package com.example.retrofitemployeemanagement.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitemployeemanagement.network.EmployeeAPI

class UpdateEmployeeViewModelFactory(private val employeeAPI: EmployeeAPI) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UpdateEmployeeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UpdateEmployeeViewModel(employeeAPI) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}