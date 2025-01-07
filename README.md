# Doable Backend

## Introduction

The backend for the Doable task management app is built using Java Spring Boot and MongoDB. This project provides
RESTful APIs to manage users and tasks efficiently, ensuring a smooth experience for task tracking and management.

## Features

- Add, get and delete users by ID.
- Add, get, update, delete tasks by ID.

## Getting Started

### Option 1

1. Build the project

    ```bash
    ./mvnw package
    ```

2. Run the app

    ```bash
     java -jar .\target\doablebackend-0.0.1-SNAPSHOT.jar
    ```

### Option 2

1. Build and run the app

    ```bash
      ./mvnw spring-boot:run
    ```

## API Endpoints

### User management

| Method   | URL           | Description                 |
|----------|---------------|-----------------------------|
| `POST`   | `/users`      | Add a user                  |
| `GET`    | `/users/{id}` | Retrieve user details by ID |
| `DELETE` | `/users/{id}` | Delete user by ID           |

### Task management

| Method   | URL                      | Description                     |
|----------|--------------------------|---------------------------------|
| `POST`   | `/tasks?userId={userId}` | Add a task to a specific user   |
| `GET`    | `/tasks/{id}`            | Retrieve task by ID             |
| `DELETE` | `/task/{id}`             | Delete task by ID               |
| `PUT`    | `/tasks/done/{id}`       | Update task status to "done"    |
| `PUT`    | `/tasks/pending/{id}`    | Update task status to "pending" |       