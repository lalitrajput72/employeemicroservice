package com.employee.employeemicroservice.service;

import java.util.List;
import java.util.Optional;

import com.employee.employeemicroservice.entity.Employee;

public interface EmployeeService{
  
	//Employee findByName(String name);
	List<Employee> findAll();
	Employee findByName(String name) ;
	List<Employee> findByDesignationCode(String designationCode);
	Employee save(Employee employee);
	Optional<Employee> findById(int id);
	Employee deleteById(int id);
}
