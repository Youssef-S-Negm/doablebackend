package com.youssef.doablebackend.service;

import com.youssef.doablebackend.dao.TaskRepository;
import com.youssef.doablebackend.dao.UserRepository;
import com.youssef.doablebackend.entity.Task;
import com.youssef.doablebackend.entity.User;
import com.youssef.doablebackend.exception.TaskNotFoundException;
import com.youssef.doablebackend.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task findById(String id) throws TaskNotFoundException {
        Optional<Task> result = taskRepository.findById(id);

        if (result.isEmpty()) throw new TaskNotFoundException("Task id - " + id + " not found");

        return result.get();
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Optional<Task> result = taskRepository.findById(id);

        if (result.isEmpty()) throw new TaskNotFoundException("Task id - " + id + " not found");

        taskRepository.delete(result.get());
    }

    @Override
    @Transactional
    public void updateStatusById(String id, String status) {
        Optional<Task> result = taskRepository.findById(id);

        if (result.isEmpty()) throw new TaskNotFoundException("Task id - " + id + " not found");

        result.get().setStatus(status);
        taskRepository.save(result.get());
    }

    @Override
    @Transactional
    public void addTaskToUser(String id, Task task) {
        Optional<User> result = userRepository.findById(id);

        if (result.isEmpty()) throw new UserNotFoundException("User id - " + id + " not found");

        task.setUserId(result.get().getId());

        taskRepository.save(task);
    }
}
