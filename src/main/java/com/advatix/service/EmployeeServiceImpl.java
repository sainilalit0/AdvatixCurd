package com.advatix.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advatix.model.Employee;
import com.advatix.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {

		employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> listOfEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int id) {
		Employee theEmployee = employeeRepository.findById(id).orElseThrow();
		/*
		 * Optional<Employee> result=employeeRepository.findById(id); Employee
		 * theEmployee=null;
		 * 
		 * try { if(result.isPresent()) { theEmployee=result.get(); } } catch (Exception
		 * e) { throw new RuntimeException(" employee id is not found"+id); }
		 */
		return theEmployee;
	}

	@Override
	public Employee updateEmployee(int id, Employee theEmployee) {
		theEmployee.setEmpId(id);

		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteByEmployeeId(int id) {
		 employeeRepository.deleteById(id);;
	}

}
