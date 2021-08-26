package com.advatix.service;

import java.util.List;

import com.advatix.model.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	List<Employee> listOfEmployees();

	Employee findEmployeeById(int id);

	Employee updateEmployee(int id, Employee theEmployee);

	void deleteByEmployeeId(int id);

}
