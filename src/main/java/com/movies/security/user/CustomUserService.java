package com.movies.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService {

    @Autowired
    private CustomUserRepository userRepo;

    public void registerUser(CustomUserClass user) throws IllegalArgumentException {

        if (userRepo.findByLogin(user.getLogin()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        userRepo.save(user);
    }
}
