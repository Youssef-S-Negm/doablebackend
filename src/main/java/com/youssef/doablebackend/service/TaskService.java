package com.youssef.doablebackend.service;

import com.youssef.doablebackend.dao.TaskRepository;
import com.youssef.doablebackend.dao.UserRepository;
import com.youssef.doablebackend.entity.Task;
import com.youssef.doablebackend.entity.User;
import com.youssef.doablebackend.exception.NotUserTaskException;
import com.youssef.doablebackend.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        task.setUserId(user.getId());
        taskRepository.save(task);
    }

    @Override
    public Task findById(String id) throws TaskNotFoundException {
        Optional<Task> result = taskRepository.findById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        if (result.isEmpty()) throw new TaskNotFoundException("Task id - " + id + " not found");

        Task task = result.get();

        if (!task.getUserId().equals(user.getId()))
            throw new NotUserTaskException("task id - " + id + " is not owned by user id - " + user.getId());

        return task;
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Optional<Task> result = taskRepository.findById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        if (result.isEmpty())
            throw new TaskNotFoundException("Task id - " + id + " not found");

        Task task = result.get();

        if (!task.getUserId().equals(user.getId()))
            throw new NotUserTaskException("task id - " + id + " is not owned by user id - " + user.getId());

        taskRepository.delete(task);
    }

    @Override
    @Transactional
    public void updateStatusById(String id, String status) throws TaskNotFoundException {
        Optional<Task> result = taskRepository.findById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        if (result.isEmpty())
            throw new TaskNotFoundException("Task id - " + id + " not found");

        Task task = result.get();

        if (!task.getUserId().equals(user.getId()))
            throw new NotUserTaskException("task id - " + id + " is not owned by user id - " + user.getId());

        task.setStatus(status);
        taskRepository.save(task);
    }
}
