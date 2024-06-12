package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ProductDao;
import com.example.demo.model.po.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	
	public List<Product> findAll(){
		return productDao.findAll();
	}
	
	public Optional<Product> findById(Integer id) {
		return productDao.findById(id);
	}
}
