package com.bjit.ecommerce.service;

import com.bjit.ecommerce.dto.UserDTO;
import com.bjit.ecommerce.entity.AddressEntity;

import java.util.List;

public interface AddressService {

    UserDTO createNewAddress(AddressEntity newAddress);

    UserDTO updateExistingAddress(AddressEntity existingAddress, long id);

    List<UserDTO> findAllAddress();

    UserDTO findAddressById(long id);

    void deleteAddress(long id);
}
