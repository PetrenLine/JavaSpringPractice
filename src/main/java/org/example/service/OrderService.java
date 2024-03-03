package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDTO;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.mapper.OrderMapper;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    public Order create(OrderDTO dto) {
        Order order = OrderMapper.INSTANCE.orderDTOToOrder(dto);
        Customer customer = customerService.readById(dto.getCustomerId());
        order.setCustomer(customer);
        return orderRepository.save(order);
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
