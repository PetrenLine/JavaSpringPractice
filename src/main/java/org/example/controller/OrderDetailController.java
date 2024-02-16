package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.entity.OrderDetail;
import org.example.entity.Product;
import org.example.service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetail")
@AllArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> readAll() {
        return new ResponseEntity<>(orderDetailService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OrderDetail> update(@RequestBody OrderDetail orderDetail) {
        return new ResponseEntity<>(orderDetailService.update(orderDetail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        orderDetailService.delete(id);
        return HttpStatus.OK;
    }

}

