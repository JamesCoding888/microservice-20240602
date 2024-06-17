package com.example.demo.model.po;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Integer id;
	private Integer customerId;
	private String orderDate;
	private Integer total;
	private List<Item> items = new CopyOnWriteArrayList<>();
}
