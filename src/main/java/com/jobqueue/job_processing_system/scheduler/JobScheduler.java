package com.jobqueue.job_processing_system.scheduler;

import com.jobqueue.job_processing_system.model.Job;
import com.jobqueue.job_processing_system.service.JobProcessor;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    private final Lock lock = new ReentrantLock();

    public String add(Job job) throws InterruptedException {
        try {
            lock.lock();
            queue.add(job);
            job.setStatus("Awaiting");
            if (queue.size() == 10) {
                jobProcessor.processJobs(queue); // now async works
            }
            return "Awaiting";

        } catch (Exception e) {
            return "Failed";
        } finally {
            lock.unlock();
        }
    }

    public void getNextJob() {
        try {
            lock.lock();
            Job temp = queue.poll();
            if (temp != null) System.out.println("Retrieved job from queue: " + temp.getname());

        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        lock.lock();
        try {
            return queue.isEmpty();
        } finally {
            lock.unlock();
        }
    }
}
