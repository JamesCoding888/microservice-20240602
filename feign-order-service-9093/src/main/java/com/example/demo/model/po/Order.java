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
    private Integer id;                 // Order ID
    private Integer customerId;         // Customer ID
    private String orderDate;           // Order date
    private Integer total;              // Total amount
    private List<Item> items = new CopyOnWriteArrayList<>();   // Order details
}

