package com.employee.employeemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeemicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemicroserviceApplication.class, args);
	}

}
