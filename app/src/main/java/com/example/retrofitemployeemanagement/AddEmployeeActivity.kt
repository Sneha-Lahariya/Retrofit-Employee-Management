package com.example.retrofitemployeemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.retrofitemployeemanagement.databinding.ActivityAddEmployeeBinding
import com.example.retrofitemployeemanagement.model.Employee
import com.example.retrofitemployeemanagement.network.RetrofitClient
import com.example.retrofitemployeemanagement.viewmodel.AddEmployeeViewModel
import com.example.retrofitemployeemanagement.viewmodel.AddEmployeeViewModelFactory

class AddEmployeeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEmployeeBinding

    private val addEmployeeViewModel: AddEmployeeViewModel by viewModels {
        AddEmployeeViewModelFactory(RetrofitClient.employeeAPI)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityAddEmployeeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.btnSubmit.setOnClickListener {
            getData()
        }

        observeLiveData()

    }

    private fun observeLiveData() {
        addEmployeeViewModel.employeeLiveData.observe(this, {
            resetData()
            Toast.makeText(this, "Employee Added Successfully!", Toast.LENGTH_SHORT).show()
        })
    }

    private fun resetData() {
        with(binding){
            etFirstName.setText("")
            etLastName.setText("")
            etDesignation.setText("")
            etDepartment.setText("")
            etAddress.setText("")
        }
    }

    private fun getData() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val designation = binding.etDesignation.text.toString()
        val department = binding.etDepartment.text.toString()
        val address = binding.etAddress.text.toString()

        val employee = Employee(0, firstName, lastName, designation, department, address)

        addEmployeeViewModel.addEmployee(employee)
    }
}