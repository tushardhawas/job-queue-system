package com.jobqueue.job_processing_system.model;

public class Job {
    Long Id;
    String Priority;
    String Name;

    public Job(Long id, String priority, String name) {
        Id = id;
        Priority = priority;
        Name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
