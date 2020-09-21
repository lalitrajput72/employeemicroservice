package com.employee.employeemicroservice.service;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findByDesignationCode(String designationCode) {
		return employeeRepository.findByDesignationCode(designationCode);
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee deleteById(int id) {
		return employeeRepository.deleteById(id);
	}
	
	
}
