package com.bjit.ecommerce.service.implementation;

import com.bjit.ecommerce.dto.CartOrderRequestDTO;
import com.bjit.ecommerce.dto.OrderResponseDTO;
import com.bjit.ecommerce.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderResponseDTO placeOrder(CartOrderRequestDTO cartOrderRequestDTO) {
        return null;
    }
}
