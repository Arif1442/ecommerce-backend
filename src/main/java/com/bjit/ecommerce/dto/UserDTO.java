package com.bjit.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String name;
    private String phone;
    private String email;
    private String street;
    private String city;
    private int postalCode;
}
