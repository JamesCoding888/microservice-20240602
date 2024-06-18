package com.example.demo.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.po.Product;
import com.example.demo.model.response.ApiResponse;

@FeignClient(name = "FEIGN-PRODUCT-SERVICE-9091") // spring.application.name
public interface ProductClient {
	@GetMapping("/products/{id}")
	ApiResponse<Product> getProductById(@PathVariable("id") Integer id);
}
