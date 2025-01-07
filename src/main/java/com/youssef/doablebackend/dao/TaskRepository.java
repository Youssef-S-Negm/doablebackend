package com.youssef.doablebackend.dao;

import com.youssef.doablebackend.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
