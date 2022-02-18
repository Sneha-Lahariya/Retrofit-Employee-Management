package com.example.retrofitemployeemanagement.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitemployeemanagement.model.Employee
import com.example.retrofitemployeemanagement.network.EmployeeAPI
import kotlinx.coroutines.launch
import retrofit2.Response

class AddEmployeeViewModel(private val employeeAPI: EmployeeAPI) : ViewModel() {

    val employeeLiveData = MutableLiveData<Response<Employee>>()

    fun addEmployee(employee: Employee) {
        viewModelScope.launch {
            employeeLiveData.value = employeeAPI.addEmployee(employee)
        }
    }

}