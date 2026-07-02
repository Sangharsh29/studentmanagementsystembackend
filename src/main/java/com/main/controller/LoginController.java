package com.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.entity.User;
import com.main.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        User user = userRepository.findByUsernameAndPassword(
                loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return "SUCCESS";
        }
        return "FAILED";
    }
}