package com.example.retrofitemployeemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.retrofitemployeemanagement.adapter.EmployeeAdapter
import com.example.retrofitemployeemanagement.databinding.ActivityShowAllEmployeesBinding
import com.example.retrofitemployeemanagement.network.RetrofitClient
import com.example.retrofitemployeemanagement.viewmodel.ShowAllEmployeesViewModel
import com.example.retrofitemployeemanagement.viewmodel.ShowAllEmployeesViewModelFactory

class ShowAllEmployeesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowAllEmployeesBinding

    private val showAllEmployeesViewModel: ShowAllEmployeesViewModel by viewModels {
        ShowAllEmployeesViewModelFactory(RetrofitClient.employeeAPI)
    }

    private lateinit var adapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityShowAllEmployeesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showAllEmployeesViewModel.getAllEmployees()

        adapter = EmployeeAdapter(onDeleteClick = {employee ->
            showAllEmployeesViewModel.deleteEmployee(employee)
            Toast.makeText(this, "Employee Deleted", Toast.LENGTH_SHORT).show()
        })
        binding.rvEmployees.adapter = adapter

        showAllEmployeesViewModel.employeeLiveData.observe(this, {
            adapter.setData(it)
        })

    }

}