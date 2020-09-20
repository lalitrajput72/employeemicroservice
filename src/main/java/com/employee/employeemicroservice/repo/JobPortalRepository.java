package com.employee.employeemicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employeemicroservice.entity.JobPortal;

@Repository
public interface JobPortalRepository extends JpaRepository<JobPortal, Integer>{

}
