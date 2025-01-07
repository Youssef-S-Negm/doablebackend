package com.youssef.doablebackend.service;

import com.youssef.doablebackend.entity.Task;

public interface ITaskService {

    void save(Task task);

    Task findById(String id);

    void delete(Task task);
}
