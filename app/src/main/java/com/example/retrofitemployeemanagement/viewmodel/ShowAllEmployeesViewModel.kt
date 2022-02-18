package com.example.retrofitemployeemanagement.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitemployeemanagement.model.Employee
import com.example.retrofitemployeemanagement.network.EmployeeAPI
import kotlinx.coroutines.launch

class ShowAllEmployeesViewModel(private val employeeAPI: EmployeeAPI): ViewModel() {

    val employeeLiveData = MutableLiveData<List<Employee>>()

    fun getAllEmployees() {
        viewModelScope.launch {
            employeeLiveData.value = employeeAPI.getAllEmployees()
        }
    }

    fun deleteEmployee(employee: Employee) {
        viewModelScope.launch {
            val response = employeeAPI.deleteEmployee(employee.id)
            if(response.isSuccessful)
                employeeLiveData.value = employeeAPI.getAllEmployees()
        }
    }

}