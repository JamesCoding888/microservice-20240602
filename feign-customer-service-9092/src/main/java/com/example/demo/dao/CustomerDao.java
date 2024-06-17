package com.example.demo.dao;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;
import com.example.demo.model.po.Customer;

@Repository
public class CustomerDao {
	private static List<Customer> customers;
	
	static {
		customers = new CopyOnWriteArrayList<>();
		customers.add(new Customer(1, "james", "james@hotmail.com"));
		customers.add(new Customer(2, "tom", "tom@hotmail.com"));
		customers.add(new Customer(3, "david", "david@hotmail.com"));
		System.out.println(customers);
	}
	
	public List<Customer> findAll(){		 
		return customers;
	}
	
	public Optional<Customer> findById(Integer id){
		return customers.stream().filter((Customer customer) -> 
				customer.getId().equals(id)).findFirst();
	}
}