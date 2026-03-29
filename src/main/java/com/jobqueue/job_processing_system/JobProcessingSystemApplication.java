package com.jobqueue.job_processing_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JobProcessingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobProcessingSystemApplication.class, args);
    }

}
