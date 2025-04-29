//package com.bjit.ecommerce.service.auth;
//
//import org.springframework.security.core.userdetails.*;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("admin".equals(username)) {
//            return User.builder()
//                    .username("admin")
//                    .password("{noop}password")  // {noop} for no encryption, use password encoder in real scenarios
//                    .roles("USER")
//                    .build();
//        } else {
//            throw new UsernameNotFoundException("User not found");
//        }
//    }
//}
