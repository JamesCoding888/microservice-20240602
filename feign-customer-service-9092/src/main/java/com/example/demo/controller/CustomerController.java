package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.po.Customer;
import com.example.demo.model.response.ApiResponse;
import com.example.demo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping // using root end-point
	public ResponseEntity<ApiResponse<List<Customer>>> findAll(){
		List<Customer> customers = customerService.findAll();
		ApiResponse<List<Customer>> apiResponse = null;
		if(customers.isEmpty()) {
			apiResponse = new ApiResponse<List<Customer>>(false, "No data", null);
		} else {
			apiResponse = new ApiResponse<List<Customer>>(true, "Data is: " + customers.size(), customers);
		}
		return ResponseEntity.ok(apiResponse); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Customer>> findById(@PathVariable Integer id){
		Optional<Customer> customer = customerService.findById(id);
		ApiResponse<Customer> apiResponse = null;
		if(customer.isEmpty()){
			apiResponse = new ApiResponse<Customer>(false, "No data", null);
		} else {
			apiResponse = new ApiResponse<Customer>(true, "Get data", customer.get());
		}
		return ResponseEntity.ok(apiResponse);
	}	
}
