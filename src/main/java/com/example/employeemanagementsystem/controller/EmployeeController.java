package com.example.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId){
		 Employee thEmployee = employeeService.findById(employeeId);
		 
		 if(thEmployee == null) {
			 throw new RuntimeException("Employee id not found - " +employeeId);
		 }
		 
		 return thEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee thEmployee) {
		
		Employee dbEmployee = employeeService.save(thEmployee);
		
		return dbEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		Employee dbEmployee = employeeService.save(employee);
		
		return dbEmployee;
		
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found : " +employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Employee deleted with id : " +employeeId;
	}
	
}















