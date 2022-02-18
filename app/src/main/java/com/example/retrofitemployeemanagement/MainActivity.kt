package com.example.retrofitemployeemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitemployeemanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAddEmployee.setOnClickListener {
            val intent = Intent(this, AddEmployeeActivity::class.java)
            startActivity(intent)
        }

        binding.btnShowAllEmployees.setOnClickListener {
            val intent = Intent(this, ShowAllEmployeesActivity::class.java)
            startActivity(intent)
        }

        binding.btnUpdateEmployee.setOnClickListener {
            val intent = Intent(this, UpdateEmployeeActivity::class.java)
            startActivity(intent)
        }

    }
}