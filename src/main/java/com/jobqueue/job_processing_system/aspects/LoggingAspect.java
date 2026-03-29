package com.jobqueue.job_processing_system.aspects;

import com.jobqueue.job_processing_system.model.AuditLog;
import com.jobqueue.job_processing_system.service.AuditService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private AuditService auditservice;

    @Around("execution(* com.jobqueue.job_processing_system.service.*.*(..)) && !execution(* com.jobqueue.job_processing_system.service.AuditService.*(..))")
    public Object logMethod(ProceedingJoinPoint jointpoint) {
        String methodName = jointpoint.getSignature().toShortString();
        Object[] args = jointpoint.getArgs();
        Object result = null;
        String status = "Success";

        long startTime = System.currentTimeMillis();

        try {
            result = jointpoint.proceed();

        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            long duration = System.currentTimeMillis() - startTime;

            AuditLog log = new AuditLog(methodName, args, result, status);
            auditservice.addLogs(log);

            System.out.println("⏱ Duration: " + duration + "ms");
        }
        return result;
    }
}
