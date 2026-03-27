package com.jobqueue.job_processing_system.model;

public class Job {
    Long id;
    Priority priority;
    String name;
    String status;
    long timestamp;


    public enum Priority {
        HIGH(1), MEDIUM(2), LOW(3);

        private final int rank;

        Priority(int i) {
            rank = i;
        }

        public int getPriority() {
            return rank;
        }
    }

    public Job(Long id, String name, Priority priority, String status, long timestamp) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.status = status;
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Job(String priority, String name) {
        id = id;
        priority = priority;
        name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        id = id;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    public String getname() {
        return name;
    }

    public void setname(String name) {
        name = name;
    }
}
