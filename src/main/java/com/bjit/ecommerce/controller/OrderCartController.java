package com.bjit.ecommerce.controller;

import com.bjit.ecommerce.dto.CartOrderRequestDTO;
import com.bjit.ecommerce.dto.OrderResponseDTO;
import com.bjit.ecommerce.service.CartService;
import com.bjit.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class OrderCartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    // Add products to the cart
    @PostMapping("/addToCart/{productId}")
    public ResponseEntity<?> addToCart(@RequestBody CartOrderRequestDTO cartOrderRequestDTO) {
        cartService.addProductToCart(cartOrderRequestDTO);
        return ResponseEntity.ok("Product added to cart successfully.");
    }

    //view cart
    @GetMapping("/viewCart")
    public ResponseEntity<?> viewCart(@RequestParam String token) {
        // Implement logic to retrieve and return the cart details
        return ResponseEntity.ok("Cart details");
    }

    // Remove a product from the cart
    @DeleteMapping("/removeFromCart/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long productId, @RequestParam String token) {
        // Implement logic to remove the product from the cart
        return ResponseEntity.ok("Product removed from cart successfully.");
    }

    // Place an order
    @PostMapping("/order")
    public ResponseEntity<?> placeOrder(@RequestBody CartOrderRequestDTO cartOrderRequestDTO, @RequestParam String token) {
        OrderResponseDTO order = orderService.placeOrder(cartOrderRequestDTO);
        return ResponseEntity.ok(order);
    }
}
