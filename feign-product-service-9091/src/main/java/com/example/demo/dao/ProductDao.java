package com.example.demo.dao;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;
import com.example.demo.model.po.Product;

@Repository
public class ProductDao {

	private static List<Product> products;
	
	static {
		products = new CopyOnWriteArrayList<>();
		products.add(new Product(1, "book", 10, 5, 5));
		products.add(new Product(2, "cake", 20, 3, 3));
	}
	
	public List<Product> findAll(){
		return products;
	}
	
	public Optional<Product> findById(Integer id) {
		return products.stream().filter(product -> product.getId().equals(id)).findFirst();
	}
	
}
