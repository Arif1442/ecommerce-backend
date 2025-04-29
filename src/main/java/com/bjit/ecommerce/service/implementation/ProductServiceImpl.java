package com.bjit.ecommerce.service.implementation;

import com.bjit.ecommerce.dto.ProductResponseDTO;
import com.bjit.ecommerce.entity.ProductEntity;
import com.bjit.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductResponseDTO getProductById(Long id) {
        return null;
    }

    @Override
    public ProductResponseDTO editProduct(Long id, ProductEntity updatedProduct) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public ProductResponseDTO addProduct(ProductEntity product) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return List.of();
    }
}
