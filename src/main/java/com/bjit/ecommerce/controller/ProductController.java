package com.bjit.ecommerce.controller;

import com.bjit.ecommerce.dto.ProductResponseDTO;
import com.bjit.ecommerce.entity.ProductEntity;
import com.bjit.ecommerce.service.CartService;
import com.bjit.ecommerce.service.OrderService;
import com.bjit.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;


    //view all products
    @GetMapping("/all")
    public ResponseEntity<?> viewAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // View a single product by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> viewProduct(@PathVariable Long id) {
        ProductResponseDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // Add a new product
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductEntity product) {
        ProductResponseDTO savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // Edit an existing product
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@PathVariable Long id, @RequestBody ProductEntity updatedProduct) {
        ProductResponseDTO product = productService.editProduct(id, updatedProduct);
        return ResponseEntity.ok(product);
    }

    // Delete a product
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
