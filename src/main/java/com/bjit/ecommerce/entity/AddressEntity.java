package com.bjit.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank
    @Column(length = 50)
    private String city;

    @NotBlank
    @Column(length = 50)
    private String district;

//    @NotNull// this will not work on this. Because 'int' can't be null, it always has a default value '0'. To make this validation work, the dataType need to be changed to Integer.
//    @Column(nullable = false)/ nullable=false will have no effect on this. As described above, int can't be null.
//    @Size(min=1000, max=9999)//this @Size annotation works with String only, the max & min means the length of the String.
    @Min(1000)
    @Max(9999)
    private int postalCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false, mappedBy = "address")
    private UserEntity user;
}
