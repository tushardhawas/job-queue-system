package com.jobqueue.job_processing_system.model;

public class JobResponse {

    Long id;
    String priority;
    String name;
    String status;

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        status = status;
    }

    public JobResponse(Long id, String priority, String name, String status) {
        id = id;
        priority = priority;
        name = name;
        status = status;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        id = id;
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
