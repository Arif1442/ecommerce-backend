package com.bjit.ecommerce.controller;

import com.bjit.ecommerce.dto.UserDTO;
import com.bjit.ecommerce.entity.AddressEntity;
import com.bjit.ecommerce.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bjit/ecommerce/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@Valid @RequestBody AddressEntity newAddress) {
        UserDTO savedAddress = addressService.createNewAddress(newAddress);
        return ResponseEntity.ok(savedAddress);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@RequestBody AddressEntity existingAddress, @PathVariable long id) {
        UserDTO updatedAddress = addressService.updateExistingAddress(existingAddress, id);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAddress() {
        List<UserDTO> allAddresses = addressService.findAllAddress();
        return ResponseEntity.ok(allAddresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAddressById(@PathVariable long id) {
        UserDTO addresses = addressService.findAddressById(id);
        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExistingAddress(@PathVariable long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Address with id " + id + " deleted successfully." , HttpStatus.OK);
    }
}
