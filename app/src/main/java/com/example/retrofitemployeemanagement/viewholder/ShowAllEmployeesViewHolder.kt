package com.example.retrofitemployeemanagement.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitemployeemanagement.databinding.ItemEmployeeBinding
import com.example.retrofitemployeemanagement.model.Employee

class ShowAllEmployeesViewHolder(private val binding: ItemEmployeeBinding, private val onDeleteClick: (Employee) -> Unit): RecyclerView.ViewHolder(binding.root) {

    fun bindData(employee: Employee) {
        binding.tvEmployeeId.text = employee.id.toString()
        binding.tvEmployeeFirstName.text = employee.firstName
        binding.tvEmployeeLastName.text = employee.lastName
        binding.tvEmployeeDesignation.text = employee.designation
        binding.tvEmployeeDept.text = employee.department
        binding.tvEmployeeAddress.text = employee.address

        binding.btnDelete.setOnClickListener {
            onDeleteClick(employee)
        }
    }

}