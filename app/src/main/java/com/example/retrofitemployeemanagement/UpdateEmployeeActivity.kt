package com.example.retrofitemployeemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.retrofitemployeemanagement.databinding.ActivityUpdateEmployeeBinding
import com.example.retrofitemployeemanagement.model.Employee
import com.example.retrofitemployeemanagement.network.RetrofitClient
import com.example.retrofitemployeemanagement.viewmodel.UpdateEmployeeViewModel
import com.example.retrofitemployeemanagement.viewmodel.UpdateEmployeeViewModelFactory

class UpdateEmployeeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateEmployeeBinding

    private val updateEmployeeViewModel: UpdateEmployeeViewModel by viewModels {
        UpdateEmployeeViewModelFactory(RetrofitClient.employeeAPI)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickButtons()

        observeLiveData()

    }

    private fun observeLiveData() {
        updateEmployeeViewModel.employeeLiveData.observe(this) { employee ->
            employee?.let {
                showEmployee(it)
            }
        }

        updateEmployeeViewModel.updateLiveData.observe(this) {
            if(it == true)
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showEmployee(employee: Employee?) {
        with(binding) {
            etUpdateFirstName.setText(employee?.firstName)
            etUpdateLastName.setText(employee?.lastName)
            etUpdateDesignation.setText(employee?.designation)
            etUpdateDepartment.setText(employee?.department)
            etUpdateAddress.setText(employee?.address)

        }
    }

    private fun onClickButtons() {
        binding.btnSearch.setOnClickListener {

            val employeeId = binding.etSearchEmployeeId.text.toString().trim()
            if(employeeId.isEmpty()) {
                Toast.makeText(this, "Employee ID is required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            updateEmployeeViewModel.getEmployee(employeeId)
        }

        binding.btnUpdate.setOnClickListener {
            updateData()
        }

    }

    private fun updateData() {
        val id = binding.etSearchEmployeeId.text.toString().trim().toInt()
        val firstName = binding.etUpdateFirstName.text.toString()
        val lastName = binding.etUpdateLastName.text.toString()
        val designation = binding.etUpdateDesignation.text.toString()
        val department = binding.etUpdateDepartment.text.toString()
        val address = binding.etUpdateAddress.text.toString()

        val employee = Employee(id, firstName, lastName, designation, department, address)

        updateEmployeeViewModel.updateEmployee(employee)
    }
}