package com.vanessa.lrn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        User userObj =
                userRepository.findByUsername(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(
                                        "User not found"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(userObj.getUsername())
                .password(userObj.getPassword())
                .authorities("USER")
                .build();
    }
}