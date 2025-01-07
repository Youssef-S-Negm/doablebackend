package com.youssef.doablebackend.rest;

import com.youssef.doablebackend.entity.Task;
import com.youssef.doablebackend.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        taskService.save(task);

        return new ResponseEntity<>("task created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable String id) {
        Task task = taskService.findById(id);

        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        taskService.deleteById(id);

        return ResponseEntity.ok("task deleted successfully");
    }

    @PutMapping("/done/{id}")
    public ResponseEntity<String> updateStatusToDone(@PathVariable String id) {
        taskService.updateStatusById(id, "done");

        return ResponseEntity.ok("task id - " + id + " status updated to done");
    }

    @PutMapping("/pending/{id}")
    public ResponseEntity<String> updateStatusToPending(@PathVariable String id) {
        taskService.updateStatusById(id, "pending");

        return ResponseEntity.ok("task id - " + id + " status updated to pending");
    }
}
