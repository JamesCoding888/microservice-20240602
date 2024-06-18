package com.example.demo.model.dto;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.example.demo.model.po.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private Integer id;
	private Customer customer;
	private String orderDate;	
	private Integer total;
	private List<ItemDto> itemDtos = new CopyOnWriteArrayList<>();	
}
