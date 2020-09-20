package com.employee.employeemicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.employeemicroservice.entity.Employee;
import com.employee.employeemicroservice.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
 
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
}
