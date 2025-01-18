package com.youssef.doablebackend.rest;

import com.youssef.doablebackend.exception.NotUserTaskException;
import com.youssef.doablebackend.exception.TaskNotFoundException;
import com.youssef.doablebackend.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException exception) {
        ErrorResponse err = new ErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exception.getMessage());
        err.setTimelapse(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleTaskNotFound(TaskNotFoundException exception) {
        ErrorResponse err = new ErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exception.getMessage());
        err.setTimelapse(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(RuntimeException exception) {
        ErrorResponse err = new ErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exception.getMessage());
        err.setTimelapse(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotUserTask(NotUserTaskException exception) {
        ErrorResponse err = new ErrorResponse();

        err.setStatus(HttpStatus.FORBIDDEN.value());
        err.setMessage(exception.getMessage());
        err.setTimelapse(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
    }
}
