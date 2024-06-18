package com.example.demo.model.dto;
import com.example.demo.model.po.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	private Integer id; 
	private Product product;
	private Integer quantity;
	private Integer subtotal;
}