package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.OrderDTO;
import org.example.entity.Order;
import org.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDTO dto) {
        return new ResponseEntity<>(orderService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> readAll() {
        return new ResponseEntity<>(orderService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.update(order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        orderService.delete(id);
        return HttpStatus.OK;
    }

}
