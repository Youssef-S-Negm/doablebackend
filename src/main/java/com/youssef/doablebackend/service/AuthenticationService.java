package com.youssef.doablebackend.service;

import com.youssef.doablebackend.dao.UserRepository;
import com.youssef.doablebackend.dto.LoginDto;
import com.youssef.doablebackend.dto.RegistrationDto;
import com.youssef.doablebackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService implements IAuthenticationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    @Transactional
    public User signUp(RegistrationDto registrationDto) {
        User user = new User(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword())
        );

        return userRepository.save(user);
    }

    @Override
    public User login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));

        return userRepository.findByEmail(loginDto.getEmail());
    }
}
