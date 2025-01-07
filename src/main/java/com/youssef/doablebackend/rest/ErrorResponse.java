package com.youssef.doablebackend.rest;

public class ErrorResponse {

    private int status;
    private String message;
    private long timelapse;

    public ErrorResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimelapse() {
        return timelapse;
    }

    public void setTimelapse(long timelapse) {
        this.timelapse = timelapse;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timelapse=" + timelapse +
                '}';
    }
}
