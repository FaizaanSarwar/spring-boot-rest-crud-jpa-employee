package com.example.employeemanagementsystem.service;

import java.util.List;

import com.example.employeemanagementsystem.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee theEmployee);

	void deleteById(int id);
}
