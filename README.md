# Doable Backend

## Introduction

The backend for the Doable task management app is built using **Java Spring Boot** and **MongoDB**. This project provides
REST APIs to manage users and tasks efficiently, ensuring a smooth experience for task tracking and management.

## Features

- Register and authenticate users using JWT.
- Add, get, update, and delete tasks by ID.

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

### User authentication

| Method | URL            | Body                                                                                     | Description                                                             |
|--------|----------------|------------------------------------------------------------------------------------------|-------------------------------------------------------------------------|
| `POST` | `/auth/signUp` | `{"firstName": "string", "lastName": "string", "email": "string", "password": "string"}` | Register user and return user metadata.                                 |
| `POST` | `/auth/login`  | `{"email": "string", "password": "string"}`                                              | Generate token and return user metadata, JWT, and JWT expiration in ms. |

### Task management

| Method   | URL                   | Body                  | Description                     |
|----------|-----------------------|-----------------------|---------------------------------|
| `POST`   | `/tasks`              | `{"title": "string"}` | Add a task to a specific user   |
| `GET`    | `/tasks/{id}`         | None                  | Retrieve task by ID             |
| `DELETE` | `/task/{id}`          | None                  | Delete task by ID               |
| `PUT`    | `/tasks/done/{id}`    | None                  | Update task status to "done"    |
| `PUT`    | `/tasks/pending/{id}` | None                  | Update task status to "pending" |

## Note
JWT secret key and JWT expiration are included in the `application.properties` file for demonstration purpose only.