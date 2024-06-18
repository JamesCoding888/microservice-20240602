package com.example.demo.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;
import com.example.demo.model.po.Item;
import com.example.demo.model.po.Order;
@Repository
public class OrderDao {
    
    private static List<Order> orders;
    
    static {
        orders = new CopyOnWriteArrayList<>();
        // Order ID, Customer ID, Order Date, Total Amount, Order Details
        Order order1 = new Order(1, 2, "2024-06-01", 0, new ArrayList<>(List.of(
                // Order Item ID, Order ID, Product ID, Quantity Ordered, Subtotal
                new Item(1, 1, 1, 5, 0), new Item(2, 1, 3, 2, 0))));
        order1.setTotal(null);
        Order order2 = new Order(2, 1, "2024-06-02", 0, new ArrayList<>(List.of(
                // Order Item ID, Order ID, Product ID, Quantity Ordered, Subtotal
                new Item(1, 2, 2, 4, 0), new Item(2, 2, 3, 1, 0))));
        
        Order order3 = new Order(3, 3, "2024-06-03", 0, new ArrayList<>(List.of(
                // Order Item ID, Order ID, Product ID, Quantity Ordered, Subtotal
                new Item(1, 3, 1, 2, 0), new Item(2, 3, 2, 4, 0), new Item(3, 3, 3, 1, 0))));
        
        Order order4 = new Order(4, 3, "2024-06-04", 0, new ArrayList<>(List.of(
                // Order Item ID, Order ID, Product ID, Quantity Ordered, Subtotal
                new Item(1, 4, 1, 7, 0))));
        
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);        
    }

    public List<Order> findAll() {
        return orders;
    }
    
    public Optional<Order> findById(Integer id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst();
    }
    
}

