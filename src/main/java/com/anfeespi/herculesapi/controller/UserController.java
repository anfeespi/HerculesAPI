package com.anfeespi.herculesapi.controller;

import com.anfeespi.herculesapi.config.security.TokenService;
import com.anfeespi.herculesapi.dto.LoginDTO;
import com.anfeespi.herculesapi.dto.UserDTO;
import com.anfeespi.herculesapi.model.User;
import com.anfeespi.herculesapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity register(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO userDTO) {
        System.out.println("User " + userDTO.username() + " " + userDTO.password());
        Authentication authToken = new UsernamePasswordAuthenticationToken(userDTO.username(), userDTO.password());
        var authUser = authenticationManager.authenticate(authToken);
        var tokenJWT = tokenService.generateToken((User) authUser.getPrincipal());
        return ResponseEntity.ok("Token: " + tokenJWT);
        //TODO: make the token sent by email
    }
}
