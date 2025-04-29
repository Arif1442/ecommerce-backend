package com.bjit.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;  // Assumes a relationship to a User entity

    @Column(nullable = false)
    private Long productId;  // Assumes a relationship to a Product entity

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 20)
    private Boolean completeness;

    // Optional: Relationships - Uncomment if you have user and product entities and want to establish relationships
    // @ManyToOne
    // @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    // private UserEntity user;

    // @ManyToOne
    // @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
    // private ProductEntity product;
}
