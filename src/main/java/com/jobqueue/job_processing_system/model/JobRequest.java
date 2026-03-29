package com.jobqueue.job_processing_system.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JobRequest {

   String priority;
    @NotBlank(message = "Name is Required")
    String name;

    public JobRequest(String priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public String getpriority() {
        return priority;
    }

    public void setpriority(String priority) {
        this.priority = priority;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
}
