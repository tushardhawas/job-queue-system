package com.jobqueue.job_processing_system.controller;

import com.jobqueue.job_processing_system.model.Job;
import com.jobqueue.job_processing_system.model.JobRequest;
import com.jobqueue.job_processing_system.model.JobResponse;
import com.jobqueue.job_processing_system.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<JobResponse> addJob(@Valid @RequestBody JobRequest req) throws InterruptedException {
        try {
            Job job = obj.saveRecord(req.getname(), req.getpriority());
            JobResponse response = new JobResponse(job.getid(), job.getPriority().name(), job.getname(), job.getStatus());

            return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/api/job/" + job.getid()).
                    body(response);
        } catch (Exception e) {
        }
        return null;
    }
}
