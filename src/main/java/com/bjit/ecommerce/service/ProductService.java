package com.bjit.ecommerce.service;

import com.bjit.ecommerce.dto.ProductResponseDTO;
import com.bjit.ecommerce.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO editProduct(Long id, ProductEntity updatedProduct);

    void deleteProduct(Long id);

    ProductResponseDTO addProduct(ProductEntity product);

    List<ProductResponseDTO> getAllProducts();
}
