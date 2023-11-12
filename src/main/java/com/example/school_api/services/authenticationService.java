package com.example.school_api.services;

import com.example.school_api.domain.User;
import com.example.school_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class authenticationService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username).get();
    }
}
