package com.jobqueue.job_processing_system.controller;

import com.jobqueue.job_processing_system.model.JobRequest;
import com.jobqueue.job_processing_system.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    private final JobService obj;


    public JobController(JobService obj) {
        this.obj = obj;
    }

    @PostMapping("/addjob")
    public String addJob(@RequestBody JobRequest req) throws InterruptedException {
        obj.saveRecord(req.getname(),req.getpriority());
        return "added successfully";
    }


}
