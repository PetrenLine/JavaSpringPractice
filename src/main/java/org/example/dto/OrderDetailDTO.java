package org.example.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Long orderId;
    private Long productId;
    private Double price;
    private Integer quantity;
}
