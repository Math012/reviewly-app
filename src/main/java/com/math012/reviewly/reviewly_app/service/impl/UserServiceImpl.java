package com.math012.reviewly.reviewly_app.service.impl;

import com.math012.reviewly.reviewly_app.config.security.JwtUtil;
import com.math012.reviewly.reviewly_app.domain.model.Review;
import com.math012.reviewly.reviewly_app.domain.model.User;
import com.math012.reviewly.reviewly_app.domain.repository.UserRepository;
import com.math012.reviewly.reviewly_app.dto.LoginDTO;
import com.math012.reviewly.reviewly_app.dto.RegisterDTO;
import com.math012.reviewly.reviewly_app.exception.InvalidCredentials;
import com.math012.reviewly.reviewly_app.exception.RequiredFieldsException;
import com.math012.reviewly.reviewly_app.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public RegisterDTO createUser(RegisterDTO registerDTO) {
        if (registerDTO == null){
            throw new RequiredFieldsException("Por favor preencha todos os campos!");
        }
        String encryptPassword = passwordEncoder.encode(registerDTO.getPassword());
        var user = new User(
                 registerDTO.getName()
                ,registerDTO.getLastname()
                , registerDTO.getAge()
                , registerDTO.getUsername()
                ,registerDTO.getPassword());
       user.setPassword(encryptPassword);
       userRepository.save(user);
        return registerDTO;
    }

    @Override
    public String login(LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));
            return jwtUtil.generateToken(authentication.getName());
        }catch (Exception e){
            throw new InvalidCredentials("Username ou senha inválidos!");
        }
    }


}
