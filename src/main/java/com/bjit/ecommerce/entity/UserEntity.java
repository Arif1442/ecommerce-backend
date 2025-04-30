package com.bjit.ecommerce.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Phone number can't be empty")
    @Size(max = 11, min = 11, message = "Phone number must be 11 digits")
    private String phone;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @Email
    @NotBlank(message = "Email is mandatory")
    @Column(name ="user_name", unique = true, length = 100)
    private String email;

    @NotBlank
    @Size(min=8, message = "Password must be at least 8 characters long")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
