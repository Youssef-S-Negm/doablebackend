package com.youssef.doablebackend.service;

import com.youssef.doablebackend.dao.UserRepository;
import com.youssef.doablebackend.entity.User;
import com.youssef.doablebackend.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(String id) throws UserNotFoundException {
        Optional<User> result = userRepository.findById(id);

        if (result.isEmpty()) throw new UserNotFoundException("User id - " + id + " not found");

        return result.get();
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Optional<User> result = userRepository.findById(id);

        if (result.isEmpty()) throw new UserNotFoundException("User id - " + id + " not found");

        userRepository.delete(result.get());
    }
}
