package com.example.retrofitemployeemanagement.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitemployeemanagement.network.EmployeeAPI

class ShowAllEmployeesViewModelFactory(private val employeeAPI: EmployeeAPI) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowAllEmployeesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShowAllEmployeesViewModel(employeeAPI) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}