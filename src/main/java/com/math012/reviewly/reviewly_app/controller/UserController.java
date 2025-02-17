package com.math012.reviewly.reviewly_app.controller;

import com.math012.reviewly.reviewly_app.domain.model.Review;
import com.math012.reviewly.reviewly_app.dto.LoginDTO;
import com.math012.reviewly.reviewly_app.dto.RegisterDTO;
import com.math012.reviewly.reviewly_app.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> createUser(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(userService.createUser(registerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO user){
        return ResponseEntity.ok(userService.login(user));
    }


}
