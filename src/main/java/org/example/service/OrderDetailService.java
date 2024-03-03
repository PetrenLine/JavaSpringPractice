package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDetailDTO;
import org.example.entity.OrderDetail;
import org.example.repository.OrderDetailRepository;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final ProductService productService;

    public OrderDetail create(OrderDetailDTO dto) {
        return orderDetailRepository.save(OrderDetail.builder()
                .order(orderService.readById(dto.getOrderId()))
                .product(productService.readById(dto.getProductId()))
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build());

    }

    public List<OrderDetail> readAll() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail update(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public void delete(Long id) {
        orderDetailRepository.deleteById(id);
    }

    public OrderDetail findById(Long id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

}

