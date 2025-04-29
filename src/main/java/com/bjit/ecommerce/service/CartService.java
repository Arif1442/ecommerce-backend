package com.bjit.ecommerce.service;

import com.bjit.ecommerce.dto.CartOrderRequestDTO;

public interface CartService {
    void addProductToCart(CartOrderRequestDTO cartOrderRequestDTO);
}
