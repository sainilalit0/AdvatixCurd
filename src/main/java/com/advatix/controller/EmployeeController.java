package com.advatix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advatix.model.Employee;
import com.advatix.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee;
	}

	@GetMapping("/listOfEmployees")
	public List<Employee> listOfEmployees() {
		return employeeService.listOfEmployees();
	}

	@GetMapping("/findById/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		Employee theEmplyee = employeeService.findEmployeeById(id);
		if (theEmplyee == null) {
			throw new RuntimeException(" Not found");
		}
		return theEmplyee;
	}

	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee theEmployee) {
		Employee employee = employeeService.updateEmployee(id, theEmployee);
		return employee;

	}
	
	@DeleteMapping("/deleteByEmployeeId/{id}")
	public void deleteByEmployeeId(@PathVariable int id) {
	 employeeService.deleteByEmployeeId(id);
	 
	}

}
