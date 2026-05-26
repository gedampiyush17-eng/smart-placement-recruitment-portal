package com.placementportal.backend.service;

import com.placementportal.backend.entity.User;
import com.placementportal.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public User registerUser(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}