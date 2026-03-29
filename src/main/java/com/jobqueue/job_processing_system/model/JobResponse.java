package com.jobqueue.job_processing_system.model;

public class JobResponse {

    Integer id;
    String priority;
    String name;
    String status;

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        status = status;
    }

    public JobResponse(Integer id, String priority, String name, String status) {
        this.id = id;
        this.priority = priority;
        this.name = name;
        this.status = status;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
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
