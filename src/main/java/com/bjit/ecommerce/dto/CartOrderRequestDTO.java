package com.bjit.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartOrderRequestDTO {
    private Long productId;
    private Integer quantity;
}
