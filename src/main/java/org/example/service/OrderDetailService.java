package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDetailDTO;
import org.example.entity.Order;
import org.example.entity.OrderDetail;
import org.example.entity.Product;
import org.example.mapper.OrderDetailMapper;
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
        OrderDetail orderDetail = OrderDetailMapper.INSTANCE.orderDetailDTOToOrderDetail(dto);
        Order order = orderService.readById(dto.getOrderId());
        Product product = productService.readById(dto.getProductId());
        orderDetail.setOrder(order);
        orderDetail.setProduct(product);
        return orderDetailRepository.save(orderDetail);
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

