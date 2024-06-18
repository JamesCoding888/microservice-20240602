package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.dto.OrderDto;
import com.example.demo.model.response.ApiResponse;
import com.example.demo.service.OrderService;
@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<ApiResponse<OrderDto>> getOrderById(
			@PathVariable Integer orderId){
		OrderDto orderDto = orderService.getOrderById(orderId);		
		ApiResponse<OrderDto> apiResponse = null;
		if(orderDto == null) {
			apiResponse = new ApiResponse<>(false, "No order data", null);
		} else {
			apiResponse = new ApiResponse<>(true, "Received order data", orderDto);			
		}
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping // using root path
	public ResponseEntity<ApiResponse<List<OrderDto>>> findAll(){
		List<OrderDto> orderDtos = orderService.findAll();
		ApiResponse<List<OrderDto>> apiResponse = null;
		if(orderDtos.isEmpty()) {
			apiResponse = new ApiResponse<>(false, "No Data", null);
		} else {
			apiResponse = new ApiResponse<>(true, "Received order data size:" + orderDtos.size(), orderDtos);
		}
		return ResponseEntity.ok(apiResponse);
	} 
}
