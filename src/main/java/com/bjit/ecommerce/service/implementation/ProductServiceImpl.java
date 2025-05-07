package com.bjit.ecommerce.service.implementation;

import com.bjit.ecommerce.dto.ProductResponseDTO;
import com.bjit.ecommerce.entity.ProductEntity;
import com.bjit.ecommerce.entity.Role;
import com.bjit.ecommerce.repository.ProductRepository;
import com.bjit.ecommerce.service.ProductService;
import com.bjit.ecommerce.service.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    Utility utility;


    @Autowired
    ProductRepository productRepo;

    @Override
    public ProductResponseDTO addProduct(String jwtToken, ProductEntity newProduct) {
        if( ! utility.validateJwtTokenWithRole(jwtToken, Role.ADMIN) ) {
            throw  new NullPointerException("The use don't have the permission to access this service.");
        }

        ProductEntity savedProduct = productRepo.save(newProduct);
        ProductResponseDTO product = entityToDtoMapper(savedProduct);

        return product;
    }

    @Override
    public ProductResponseDTO updateProduct(String jwtToken, long id, ProductEntity updatedProduct) {
        if( ! utility.validateJwtTokenWithRole(jwtToken, Role.ADMIN) ) {
            throw  new NullPointerException("The use don't have the permission to access this service.");
        }

        ProductEntity existingProduct = productRepo.findById(id).orElseThrow(() -> new NullPointerException("No product with id " + id + " exists."));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setPrice(updatedProduct.getPrice());

        ProductEntity savedProduct = productRepo.save(existingProduct);
        ProductResponseDTO product = entityToDtoMapper(savedProduct);

        return product;
    }

    @Override
    public void deleteProduct(String jwtToken, Long id) {
        if( ! utility.validateJwtTokenWithRole(jwtToken, Role.ADMIN) ) {
            throw  new NullPointerException("The use don't have the permission to access this service.");
        }

        ProductEntity existingProduct = productRepo.findById(id).orElseThrow(() -> new NullPointerException("No product with id " + id + " exists."));
        productRepo.delete(existingProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> allProducts = new ArrayList<>();

        productRepo.findAll().forEach(product -> {
            allProducts.add( entityToDtoMapper(product) );
        });

        return allProducts;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        ProductEntity existingProduct = productRepo.findById(id).orElseThrow(() -> new NullPointerException("No product with id " + id + " exists."));
        ProductResponseDTO expectedProduct = entityToDtoMapper(existingProduct);

        return expectedProduct;
    }

    private ProductResponseDTO entityToDtoMapper(ProductEntity productEntity) {
        ProductResponseDTO productDto = ProductResponseDTO.builder()
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .quantity(productEntity.getQuantity())
                .price(productEntity.getPrice())
                .build();

        return productDto;
    }
}
