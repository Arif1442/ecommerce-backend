package com.bjit.ecommerce.service.implementation;

import com.bjit.ecommerce.dto.LoginRequestDTO;
import com.bjit.ecommerce.dto.UserDTO;
import com.bjit.ecommerce.entity.UserEntity;
import com.bjit.ecommerce.repository.UserRepository;
import com.bjit.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserEntity user) {
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            UserEntity savedUser = userRepository.save(user);
            UserDTO userDTO = mapEntityToDto(savedUser);

            return userDTO;
        } catch (Exception e) {
            throw new NullPointerException("User registration failed: " + e.getMessage());
        }
    }

    @Override
    public String loginUser(LoginRequestDTO userLogin) {
//        UserEntity user = userRepository.findByEmailAndPassword(userLogin.getUsername(), new BCryptPasswordEncoder().encode(userLogin.getPassword()));
        UserEntity user = userRepository.findByEmailAndPassword(userLogin.getUsername(), userLogin.getPassword());
        if (user == null) {
            throw new NullPointerException("Invalid email or password");
        }
        return "Here is your token brother......";
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(mapEntityToDto(user));
        });

        return users;
    }

    @Override
    public UserDTO getUserById(long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("User with id " + id + " not found"));
        UserDTO userDTO = mapEntityToDto(user);

        return userDTO;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);

        if( user == null ) {
            throw new NullPointerException("User not found with email : " + email);
        }
        UserDTO userDTO = mapEntityToDto(user);

        return userDTO;
    }

    @Override
    public UserDTO updateUser(long id, UserEntity user) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new NullPointerException("User with id " + id + " not found"));

        existingUser.setName(user.getName());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
//        existingUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());

        UserEntity updatedUser = userRepository.save(existingUser);

        if( updatedUser.getId() == null ) {
            throw new NullPointerException("User update failed");
        }
        UserDTO userDTO = mapEntityToDto(updatedUser);

        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new NullPointerException("User with id " + id + " not found"));
        userRepository.delete(existingUser);

    }

    private UserDTO mapEntityToDto(UserEntity user) {
        UserDTO userDTO = UserDTO.builder()
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
        if( user.getAddress() != null ) {
            userDTO.setStreet(user.getAddress().getStreet());
            userDTO.setCity(user.getAddress().getCity());
            userDTO.setPostalCode(user.getAddress().getPostalCode());
        }

        return userDTO;
    }
}
