package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.client.CustomerClient;
import com.example.demo.client.ProductClient;
import com.example.demo.dao.OrderDao;
import com.example.demo.model.po.Customer;
import com.example.demo.model.po.Item;
import com.example.demo.model.po.Order;
import com.example.demo.model.po.Product;
import com.example.demo.model.dto.ItemDto;
import com.example.demo.model.dto.OrderDto;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerClient customerClient;
		
	@Autowired
	private ProductClient productClient;
	
	public ItemDto convertToDto(Item item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setId(item.getId());
		itemDto.setQuantity(item.getQuantity());			
		// Acquire remote data from FEIGN-PRODUCT-SERVICE-9091
		Product product = productClient.getProductById(item.getId()).getData();
		itemDto.setProduct(product);		
		return itemDto;
	};
	
	public OrderDto convertToDto(Order order) {
		OrderDto orderDto = new OrderDto();
		orderDto.setId(order.getId());
		orderDto.setOrderDate(order.getOrderDate());
		// Acquire remote data from FEIGN-CUSTOMER-SERVICE-9092
		Customer customer = customerClient.getCustomerById(order.getId()).getData();
		orderDto.setCustomer(customer);		
		for(Item item : order.getItems()) {
			ItemDto itemDto = convertToDto(item);
			orderDto.getItemDtos().add(itemDto);
		}
		return orderDto;
	};
	
	private List<OrderDto> convertToDto(List<Order> orders) {
		//return orders.stream().map(order -> convertToDto(order)).collect(Collectors.toList());
		return orders.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	public OrderDto getOrderById(Integer orderId) {		
		Optional<Order> orderOpt= orderDao.findById(orderId);
		if(orderOpt.isEmpty()) {
			return null;
		} else {
			Order order = orderOpt.get();
			System.out.println('1');
			return convertToDto(order);	
		}	
	}
	
	public List<OrderDto> findAll() {
		List<Order> orders = orderDao.findAll();
		return convertToDto(orders);
	}
}
