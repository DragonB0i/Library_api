package com.vanessa.lrn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User userObj) {

        if (userRepository.findByUsername(
                userObj.getUsername()).isPresent()) {

            throw new RuntimeException(
                    "Username already exists");
        }

        userObj.setPassword(
                passwordEncoder.encode(
                        userObj.getPassword()));

        return userRepository.save(userObj);
    }
    public String loginUser(LoginRequest request) {

        Optional<User> userOpt =
                userRepository.findByUsername(
                        request.getUsername());

        if(userOpt.isEmpty()) {

            return null;
        }

        User user = userOpt.get();

        boolean valid =
                passwordEncoder.matches(

                        request.getPassword(),

                        user.getPassword());

        if(valid) {

            return jwtService.generateToken(
                    user.getUsername());
        }

        return null;
    }
}