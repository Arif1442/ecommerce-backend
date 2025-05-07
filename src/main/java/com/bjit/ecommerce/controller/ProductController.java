package com.bjit.ecommerce.controller;

import com.bjit.ecommerce.dto.ProductResponseDTO;
import com.bjit.ecommerce.entity.ProductEntity;
import com.bjit.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bjit/ecommerce/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewProduct(@RequestParam String jwtToken, @RequestBody ProductEntity newProduct) {
        ProductResponseDTO createdProduct = productService.addProduct(jwtToken, newProduct);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateExistingProduct(@RequestParam String jwtToken, @PathVariable long id, @RequestBody ProductEntity updatedProduct) {
        ProductResponseDTO savedProduct = productService.updateProduct(jwtToken, id, updatedProduct);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExistingProduct(@RequestParam String jwtToken, @PathVariable long id) {
        productService.deleteProduct(jwtToken, id);
        return ResponseEntity.ok("Product with id " + id + " deleted successfully.");
    }

    @GetMapping("/all")
    public ResponseEntity<?> showAllProducts() {
        List<ProductResponseDTO> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable long id) {
        ProductResponseDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
}
