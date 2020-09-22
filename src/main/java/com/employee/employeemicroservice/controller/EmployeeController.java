package com.employee.employeemicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeemicroservice.entity.Employee;
import com.employee.employeemicroservice.entity.JobPortal;
import com.employee.employeemicroservice.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	JobPortalController jobPortalController;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		List<Employee> list=employeeService.findAll();
		
		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{name}")
	public ResponseEntity<Employee> findByName(@PathVariable("name") String name){
		return new ResponseEntity<Employee>(employeeService.findByName(name), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/findByDesignation/{designationCode}")
	public ResponseEntity<List<Employee>> findByDesignation(@PathVariable("designationCode") String designationCode){
		return new ResponseEntity<List<Employee>>(employeeService.findByDesignationCode(designationCode),new HttpHeaders() , HttpStatus.OK);
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee){
		Employee emp=employeeService.save(newEmployee);
		if(emp == null) {
			return new ResponseEntity<Employee>(emp,new HttpHeaders(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(emp,new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee newEmployee,@PathVariable("id") int id){
		Employee employee=employeeService.findById(id).orElse(null);
		if(employee == null) {
			return new ResponseEntity<Employee>(employeeService.save(newEmployee),new HttpHeaders(),HttpStatus.OK);
		}
		else {
			newEmployee.setId(id);
			return new ResponseEntity<Employee>(employeeService.save(newEmployee),new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id")  int id){
		return new ResponseEntity<Employee>(employeeService.deleteById(id),new HttpHeaders(),HttpStatus.OK);
	}
	//Call JobPortal Microservice which have seperate DB.
	@GetMapping("/getReleventJobsByExperience/{yearsOfExperience}")
	public ResponseEntity<ResponseEntity<List<JobPortal>>> getReleventJobsByExperience(@PathVariable("yearsOfExperience") int yearsOfExperience){
		return new ResponseEntity<ResponseEntity<List<JobPortal>>>(jobPortalController.findByExperience(yearsOfExperience),new HttpHeaders(),HttpStatus.OK);
	}
	@HystrixCommand(fallbackMethod = "fallbackFindByDesignation")
	@GetMapping("/getReleventJobsByDesignation/{designation}")
	public ResponseEntity<ResponseEntity<List<JobPortal>>> getReleventJobsByDesignation(@PathVariable("designation") String designation){
		return new ResponseEntity<ResponseEntity<List<JobPortal>>>(jobPortalController.findByDesignation(designation),new HttpHeaders(),HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseEntity<List<JobPortal>>> fallbackFindByDesignation(String designation) {
		System.out.println("Error occurred while getting Jobs By Designation");
		return new ResponseEntity<ResponseEntity<List<JobPortal>>>(new ResponseEntity<List<JobPortal>>(new ArrayList<JobPortal>() , new HttpHeaders(),HttpStatus.BAD_REQUEST),new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}
}
