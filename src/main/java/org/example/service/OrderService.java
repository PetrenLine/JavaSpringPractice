package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.OrderDTO;
import org.example.entity.Order;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    public Order create(OrderDTO dto) {
        return orderRepository.save(Order.builder()
                .orderDate(dto.getOrderDate())
                .orderStatus(dto.getOrderStatus())
                .paymentMethod(dto.getPaymentMethod())
                .customer(customerService.readById(dto.getCustomerId()))
                .build());

    }

    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }
    public Order readById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }
}
