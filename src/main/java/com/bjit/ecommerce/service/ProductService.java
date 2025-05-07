package com.bjit.ecommerce.service;

import com.bjit.ecommerce.dto.ProductResponseDTO;
import com.bjit.ecommerce.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductResponseDTO addProduct(String jwtToken, ProductEntity product);
    ProductResponseDTO updateProduct(String jwtToken, long id, ProductEntity existingProduct);
    void deleteProduct(String jwtToken, Long id);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);

}
