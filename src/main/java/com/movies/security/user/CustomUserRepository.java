package com.movies.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<CustomUserClass, Long> {
    public default Optional<CustomUserClass> findByLogin(String login) {
        return findAll().stream().filter(userClass -> userClass.getLogin().equals(login)).findFirst();
    }
}