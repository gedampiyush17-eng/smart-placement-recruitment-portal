package com.placementportal.backend.controller;


import com.placementportal.backend.entity.User;
import com.placementportal.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.placementportal.backend.dto.LoginRequest;
import com.placementportal.backend.jwt.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    private BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();
    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request) {

        User user =
                userService.findByEmail(request.getEmail());

        if(user == null) {
            throw new RuntimeException("User not found");
        }

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword());

        if(!passwordMatches) {
            throw new RuntimeException("Invalid password");
        }

        return JwtUtil.generateToken(user.getEmail());
    }
}
