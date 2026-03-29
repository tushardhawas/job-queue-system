package com.jobqueue.job_processing_system.service;
import com.jobqueue.job_processing_system.model.Job;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class JobProcessor {

    @Async
    public void processJobs(Queue<Job> queue) throws InterruptedException {
        while (!queue.isEmpty()) {
            Thread.sleep(1000);
            Job job = queue.poll();
            job.setStatus("Completed");
            System.out.println("Processing job: " + job.getname());
        }
    }
}
