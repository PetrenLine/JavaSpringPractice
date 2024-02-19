package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private LocalDate orderDate;
    private String orderStatus;
    private String paymentMethod;
    private Long customerId;
}
