package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	// If errors occur, handling specific global exceptions becomes essential for effective error management and response in your application.
	@GetMapping("{empId}")
	public Employee getEmployee(@PathVariable Integer empId) throws InterruptedException {
		// If errors occur, handling specific global exceptions becomes essential for effective error management and response in your application. 
		if(empId < 1) {
			throw new RuntimeException("No Such Employee ID");
		} else if(empId > 10) {
			throw new RuntimeException("Network over loading and connection fail");
		}
		
		// Simulation service delaying
		Thread.sleep(2000);
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName("James" + empId);
		emp.setSalary(30000.0 * empId);	
		emp.setDescription("Engineer" + empId);
		return emp;
	}
	
	// If errors occur and you could handle them to gracefully interrupt processing
	@CircuitBreaker(name = "employeeCircuitBreaker", fallbackMethod = "getEmployeeFallback")
	@GetMapping("/breaker/{empId}")
	public Employee getEmployeeBreaker(@PathVariable Integer empId) throws InterruptedException {
		// If an error occurs will trigger the CircuitBreaker mechanism without relying on global exception handling
		if(empId < 1) {
			throw new RuntimeException("No Such Employee ID");
		} else if(empId > 10) {
			throw new RuntimeException("Network over loading and connection fail");
		}
		
		// Simulation service delaying
		Thread.sleep(2000);
		
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName("James" + empId);
		emp.setSalary(30000.0 * empId);	
		emp.setDescription("Engineer" + empId);
		return emp;
	}
	
	// FallBack method
	public Employee getEmployeeFallback(Integer empId, Throwable t) {
		// This error will be handled by global exceptions
		if (empId == 0) {
			throw new RuntimeException("無此員編 0");
		}
		
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName("Fallback");
		emp.setSalary(null);	
		emp.setDescription("Fallback Description...");
		return emp;
	}
}
