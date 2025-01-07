package com.youssef.doablebackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String title;
    private String status = "pending";
    private String userId;

    public Task() {
    }

    public Task(String userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    public Task(String title, String status, String userId) {
        this.title = title;
        this.status = status;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                '}';
    }
}
