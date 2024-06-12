package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.po.Product;
import com.example.demo.model.response.ApiResponse;
import com.example.demo.service.ProductService;
@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping // using root endpoint
	public ResponseEntity<ApiResponse<List<Product>>> findAll(){
		List<Product> products = productService.findAll();
		ApiResponse<List<Product>> apiResponse = null;
		if(products.isEmpty()) {
			apiResponse = new ApiResponse<List<Product>>(false, "No Data", null);
		} else {
			apiResponse = new ApiResponse<List<Product>>(true, "Data quantities: " + products.size(), products);
		}
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Product>> findById(@PathVariable Integer id){		
		Optional<Product> product = productService.findById(id);
		ApiResponse<Product> apiResponse = null;
		if(product.isEmpty()) {
			apiResponse = new ApiResponse<Product>(false, "No Data", null);
		} else {
			apiResponse = new ApiResponse<Product>(true, "Get Data", product.get());
		}
		return ResponseEntity.ok(apiResponse);
	}
	
}
