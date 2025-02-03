package com.anfeespi.herculesapi.service;

import com.anfeespi.herculesapi.dto.UserDTO;
import com.anfeespi.herculesapi.model.User;
import com.anfeespi.herculesapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private DataMapper mapper;

    public boolean createUser(UserDTO userDTO) {
        User user = mapper.convertUserDTOToUser(userDTO);
        repository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }
}
