package com.bjit.ecommerce.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
    private UserDTO user;
    private List<ProductResponseDTO> products;
}
