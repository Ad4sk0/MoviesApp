package com.movies.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CustomUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        CustomUserClass userClass = userRepository.
                findByLogin(login).orElseThrow(
                        () -> new UsernameNotFoundException("User with that login cannot be found"));
        return new CustomUserDetails(userClass);
    }
}
