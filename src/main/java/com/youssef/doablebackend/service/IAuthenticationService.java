package com.youssef.doablebackend.service;

import com.youssef.doablebackend.dto.LoginDto;
import com.youssef.doablebackend.dto.RegistrationDto;
import com.youssef.doablebackend.entity.User;

public interface IAuthenticationService {

    User signUp(RegistrationDto registrationDto);

    User login(LoginDto loginDto);
}
