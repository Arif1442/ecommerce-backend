package com.bjit.ecommerce.dto;

import com.bjit.ecommerce.entity.AddressEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String name;
    private String phone;
    private String email;
    private AddressEntity address;
}
