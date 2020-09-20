package com.employee.employeemicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeemicroservice.entity.JobPortal;
import com.employee.employeemicroservice.repo.JobPortalRepository;

@Service
public class JobPortalServiceImpl implements JobPortalService{

	@Autowired
	JobPortalRepository jobPortalRepository;
	@Override
	public List<JobPortal> findAll() {
		return jobPortalRepository.findAll();
	}
	
}
