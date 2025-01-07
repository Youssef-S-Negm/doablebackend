package com.youssef.doablebackend.service;

import com.youssef.doablebackend.dao.TaskRepository;
import com.youssef.doablebackend.entity.Task;
import com.youssef.doablebackend.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
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
}
