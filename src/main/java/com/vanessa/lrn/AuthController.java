package com.vanessa.lrn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request
    ) {

        String token =
                authService.loginUser(request);

        if(token != null){

            return ResponseEntity.ok(token);
        }

        return ResponseEntity.badRequest()
                .body("Invalid Credentials");}
    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody User userObj
    ) {

        User savedUser =
                authService.registerUser(userObj);

        return ResponseEntity.ok(savedUser);
    }
}