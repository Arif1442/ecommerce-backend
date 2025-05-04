package com.bjit.ecommerce.service.implementation;

import com.bjit.ecommerce.dto.UserDTO;
import com.bjit.ecommerce.entity.AddressEntity;
import com.bjit.ecommerce.repository.AddressRepository;
import com.bjit.ecommerce.service.AddressService;
import com.bjit.ecommerce.service.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepo;

    @Autowired
    Utility utility;

    @Override
    public UserDTO createNewAddress(AddressEntity newAddress) {
        AddressEntity savedAddress = addressRepo.save(newAddress);
        UserDTO userDTO = addressEntityToUserDtoMapper(savedAddress);

        return userDTO;
    }

    @Override
    public UserDTO updateExistingAddress(AddressEntity existingAddress, long id) {
        AddressEntity address = addressRepo.findById(id).orElseThrow(() -> new NullPointerException("No address with id " + id + " exists."));
        address.setStreet(existingAddress.getStreet());
        address.setCity(existingAddress.getCity());
        address.setDistrict(existingAddress.getDistrict());
        address.setPostalCode(existingAddress.getPostalCode());
        address.setUser(existingAddress.getUser());
//        address.getUser().setName(existingAddress.getUser().getName());
//        address.getUser().setEmail(existingAddress.getUser().getEmail());
//        address.getUser().setPhone(existingAddress.getUser().getPhone());
//        address.getUser().setRole(existingAddress.getUser().getRole());

        AddressEntity updatedAddress = addressRepo.save(address);
        UserDTO userDTO = addressEntityToUserDtoMapper(updatedAddress);

        return userDTO;
    }

    @Override
    public List<UserDTO> findAllAddress() {
        List<UserDTO> allUserDto = new ArrayList<>();
        List<AddressEntity> allAddress = addressRepo.findAll();

        allAddress.forEach(addressEntity -> {
            allUserDto.add( addressEntityToUserDtoMapper(addressEntity) );
        });

        return allUserDto;
    }

    @Override
    public UserDTO findAddressById(long id) {
        AddressEntity address = addressRepo.findById(id).orElseThrow(() -> new NullPointerException("No address with id " + id + " exists."));
        UserDTO userDTO = addressEntityToUserDtoMapper(address);

        return userDTO;
    }

    @Override
    public void deleteAddress(long id) {
        AddressEntity existingAddress = addressRepo.findById(id).orElseThrow(() -> new NullPointerException("No address with id " + id + " exists."));
        addressRepo.delete(existingAddress);
    }

    private UserDTO addressEntityToUserDtoMapper(AddressEntity address) {
        UserDTO userDTO = UserDTO.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .build();

        if( address.getUser() != null ) {
            userDTO.setName(address.getUser().getName());
            userDTO.setEmail(address.getUser().getEmail());
            userDTO.setPhone(address.getUser().getPhone());
        }

        return userDTO;
    }
}
