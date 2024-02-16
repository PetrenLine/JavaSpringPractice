package org.example.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String name;
    private Double price;
    private String description;
    private Boolean inStock;
}
