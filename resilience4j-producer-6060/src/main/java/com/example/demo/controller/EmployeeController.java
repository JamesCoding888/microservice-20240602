package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@GetMapping("{empId}")
	public Employee getEmployee(@PathVariable Integer empId) throws InterruptedException {
		// Simulation service delaying
		Thread.sleep(2000);
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName("James" + empId);
		emp.setSalary(30000.0 * empId);		
		return emp;
	}
}
