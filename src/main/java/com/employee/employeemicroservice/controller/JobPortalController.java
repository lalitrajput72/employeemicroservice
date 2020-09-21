package com.employee.employeemicroservice.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.employeemicroservice.entity.JobPortal;

@FeignClient(name="jobportal")
public interface JobPortalController {
	
	@GetMapping("/jobportal/findByExperience/{experience}")
	public ResponseEntity<List<JobPortal>> findByExperience(@PathVariable("experience") int experience);
	
	@GetMapping("/jobportal/findByDesignation/{designation}")
	public ResponseEntity<List<JobPortal>> findByDesignation(@PathVariable("designation") String designation);

}
