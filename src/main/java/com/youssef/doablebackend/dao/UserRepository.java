package com.youssef.doablebackend.dao;

import com.youssef.doablebackend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
