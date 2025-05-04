package com.bjit.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String street;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String district;

    @Column(nullable = false, length = 20)
    private int postalCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)//, mappedBy = "address")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
