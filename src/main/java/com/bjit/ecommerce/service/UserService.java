package com.bjit.ecommerce.service;

import com.bjit.ecommerce.dto.LoginRequestDTO;
import com.bjit.ecommerce.dto.UserDTO;
import com.bjit.ecommerce.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserEntity user);

    String loginUser(LoginRequestDTO userLogin);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(long id);

    UserDTO getUserByEmail(String email);

    UserDTO updateUser(long id, UserEntity user);

    void deleteUser(Long id);
}
