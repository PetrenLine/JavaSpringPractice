package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private Long id;
    private LocalDate orderDate;
    private String orderStatus;
    private String paymentMethod;
    private Long customerId;
}
