package com.employee.employeemicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.employeemicroservice.entity.Employee;

public interface EmployeeService{
  
	//Employee findByName(String name);
	List<Employee> findAll();
}
