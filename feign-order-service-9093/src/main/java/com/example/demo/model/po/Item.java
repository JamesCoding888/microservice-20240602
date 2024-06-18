package com.example.demo.model.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Integer id;          // Order item ID
    private Integer orderId;     // Order ID
    private Integer productId;   // Product ID
    private Integer quantity;    // Quantity ordered
    private Integer subtotal;    // Subtotal (product price * quantity)
}

