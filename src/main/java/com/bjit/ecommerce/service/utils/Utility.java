package com.bjit.ecommerce.service.utils;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Utility {

//    private final BCryptPasswordEncoder passwordEncoder;

    public Utility() {
        System.out.println("Utility Constructor Called");
//        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encodePassword(String password) {
//        return passwordEncoder.encode(password);
        return password;
    }
}
