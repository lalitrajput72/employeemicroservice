package com.employee.employeemicroservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employeemicroservice.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByName(String name);
	List<Employee> findByDesignationCode(String designationCode);
	Employee save(Employee employee);
	Employee deleteById(int id);
}
