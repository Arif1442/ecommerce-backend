package com.bjit.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
}
