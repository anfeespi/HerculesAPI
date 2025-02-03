package com.anfeespi.herculesapi.service;

import com.anfeespi.herculesapi.dto.UserDTO;
import com.anfeespi.herculesapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DataMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DataMapper() {
    }

    public User convertUserDTOToUser(UserDTO userDTO) {
        return new User(userDTO.email(), userDTO.username(), passwordEncoder.encode(userDTO.password()), true);
    }

}
