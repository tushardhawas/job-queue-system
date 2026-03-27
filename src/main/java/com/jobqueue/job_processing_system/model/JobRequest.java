package com.jobqueue.job_processing_system.model;

public class JobRequest {

    String priority;
    String name;

    public JobRequest(String priority, String name) {
        priority = priority;
        name = name;
    }

    public String getpriority() {
        return priority;
    }

    public void setpriority(String priority) {
        priority = priority;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        name = name;
    }
}
