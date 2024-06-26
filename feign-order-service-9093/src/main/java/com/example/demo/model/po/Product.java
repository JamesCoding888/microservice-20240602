package com.example.demo.model.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Integer id;
	private String name;
	private Integer price;
	private Integer cost;
	private Integer quantity;
}
