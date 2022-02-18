package com.example.retrofitemployeemanagement.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitemployeemanagement.model.Employee
import com.example.retrofitemployeemanagement.network.EmployeeAPI
import kotlinx.coroutines.launch

class UpdateEmployeeViewModel(private val employeeAPI: EmployeeAPI): ViewModel() {

    val employeeLiveData = MutableLiveData<Employee>()

    val updateLiveData = MutableLiveData<Boolean>()

    fun getEmployee(id: String) {
        viewModelScope.launch {
            val response = employeeAPI.getEmployee(id.toInt())
            if(response.isSuccessful){
                employeeLiveData.value = response.body()
            }
            else
                Log.d("search", "failed")
        }
    }

    fun updateEmployee(employee: Employee) {
        viewModelScope.launch {
            val response = employeeAPI.updateEmployee(id = employee.id, employee = employee)
            updateLiveData.value = response.isSuccessful
        }
    }

}