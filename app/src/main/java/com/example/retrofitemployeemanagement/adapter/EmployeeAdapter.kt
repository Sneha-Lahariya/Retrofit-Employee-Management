package com.example.retrofitemployeemanagement.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitemployeemanagement.databinding.ItemEmployeeBinding
import com.example.retrofitemployeemanagement.model.Employee
import com.example.retrofitemployeemanagement.viewholder.ShowAllEmployeesViewHolder

class EmployeeAdapter(private val onDeleteClick: (Employee) -> Unit): RecyclerView.Adapter<ShowAllEmployeesViewHolder>() {

    private val employeeList = mutableListOf<Employee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowAllEmployeesViewHolder {
        val binding = ItemEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowAllEmployeesViewHolder(binding, onDeleteClick)
    }

    override fun onBindViewHolder(holder: ShowAllEmployeesViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.bindData(employee)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(employee: List<Employee>) {
        employeeList.clear()
        employeeList.addAll(employee)
        notifyDataSetChanged()
    }

}