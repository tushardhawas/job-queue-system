package com.jobqueue.job_processing_system.model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class AuditLog {

    private String method;
    private String args;
    private String result;
    private String status; // SUCCESS or FAILURE
    private LocalDateTime timestamp;

    public AuditLog(String method, Object[] args, Object result, String status) {
        this.method = method;
        this.args = Arrays.toString(args);
        this.result = result != null ? result.toString() : "null";
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Method: %s | Args: %s | Result: %s | Status: %s",
                timestamp, status, method, args, result, status);
    }
}