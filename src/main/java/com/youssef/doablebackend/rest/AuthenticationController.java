package com.youssef.doablebackend.rest;

import com.youssef.doablebackend.dto.LoginDto;
import com.youssef.doablebackend.dto.LoginResponse;
import com.youssef.doablebackend.dto.RegistrationDto;
import com.youssef.doablebackend.entity.User;
import com.youssef.doablebackend.service.IAuthenticationService;
import com.youssef.doablebackend.service.IJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final IJwtService jwtService;
    private final IAuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(IJwtService jwtService, IAuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> register(@RequestBody RegistrationDto input) {
        User user = authenticationService.signUp(input);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto input) {
        User user = authenticationService.login(input);
        String token = jwtService.generateToken(user);
        LoginResponse response = new LoginResponse(token, jwtService.getExpiration(), user);

        return ResponseEntity.ok(response);
    }
}
