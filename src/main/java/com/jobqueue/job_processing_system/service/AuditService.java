package com.jobqueue.job_processing_system.service;

import com.jobqueue.job_processing_system.model.AuditLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AuditService {

    private final List<AuditLog> logs = Collections.synchronizedList(new ArrayList<>());

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addLogs(AuditLog auditlog) {

        logs.add(auditlog);
        System.out.println("log added " + auditlog.getMethod());
    }

    public List<AuditLog> getAllLogs() {
        return logs;
    }

    public void clearLogs() {
        logs.clear();
    }
}
