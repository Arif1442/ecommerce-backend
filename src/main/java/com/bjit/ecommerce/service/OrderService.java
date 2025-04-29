package com.bjit.ecommerce.service;

import com.bjit.ecommerce.dto.CartOrderRequestDTO;
import com.bjit.ecommerce.dto.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO placeOrder(CartOrderRequestDTO cartOrderRequestDTO);
}
