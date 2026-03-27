package com.jobqueue.job_processing_system.service;

import com.jobqueue.job_processing_system.model.Job;
import com.jobqueue.job_processing_system.scheduler.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class JobService {

    private final JobScheduler scheduler;
    AtomicInteger ids = new AtomicInteger(1);

    @Autowired
    public JobService(JobScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void saveRecord(String name, String priority) throws InterruptedException {
        Job.Priority priority_ = Job.Priority.valueOf(priority.toUpperCase());
        Job job = new Job((long) ids.getAndIncrement(), name, priority_, "Pending", System.currentTimeMillis());
        scheduler.add(job);

    }


}
