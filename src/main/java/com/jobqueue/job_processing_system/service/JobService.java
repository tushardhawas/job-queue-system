package com.jobqueue.job_processing_system.service;

import com.jobqueue.job_processing_system.model.Job;
import com.jobqueue.job_processing_system.scheduler.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class JobService {

    private final JobScheduler scheduler;
    AtomicInteger ids = new AtomicInteger(1);

    @Autowired
    public JobService(JobScheduler scheduler) {
        this.scheduler = scheduler;
    }

    Map<Integer, Job> store = new ConcurrentHashMap<Integer, Job>();

    public Job saveRecord(String name, String priority) throws InterruptedException {
        Job.Priority priority_ = Job.Priority.valueOf(priority.toUpperCase());
        Job job = new Job( ids.getAndIncrement(), name, priority_, "Pending", System.currentTimeMillis());
        store.put(job.getid(), job);
        String status = scheduler.add(job);
        job.setStatus(status);


        return job;

    }

//    public JobService getStatus() {
//        scheduler.add(new Job())
//    }


}
