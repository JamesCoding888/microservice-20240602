package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CustomerDao;
import com.example.demo.model.po.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	public List<Customer> findAll(){		 
		return customerDao.findAll();
	}
	
	public Optional<Customer> findById(Integer id){
		return customerDao.findById(id);
	}
}
