package com.jobqueue.job_processing_system.scheduler;

import com.jobqueue.job_processing_system.model.Job;
import com.jobqueue.job_processing_system.service.JobProcessor;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;
import java.util.Queue;

@Service
public class JobScheduler {

    private final JobProcessor jobProcessor;
    Queue<Job> queue = new PriorityQueue<>((a, b) -> {
        int value = Integer.compare(a.getPriority().getPriority(), b.getPriority().getPriority());
        if (value != 0) {
            return value;
        }
        return Long.compare(a.getTimestamp(), b.getTimestamp());
    });

    public JobScheduler(JobProcessor jobProcessor) {
        this.jobProcessor = jobProcessor;
    }

    public String add(Job job) throws InterruptedException {
        try {
            queue.add(job);
            job.setStatus("Awaiting");
            if (queue.size() == 10) {
                jobProcessor.processJobs(queue); // now async works
            }
            return "Awaiting";

        } catch (Exception e) {
            return "Failed";

        }
    }
}
