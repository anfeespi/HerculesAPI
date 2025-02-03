package com.anfeespi.herculesapi.repository;

import com.anfeespi.herculesapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<User, String> {
    UserDetails findByUsername(String username);
}
