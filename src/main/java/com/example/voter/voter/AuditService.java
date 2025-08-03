package com.example.voter.voter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.util.Base64;

@Service
public class AuditService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    public AuditLog logAction(String action, String details) {
        AuditLog lastLog = auditLogRepository.findTopByOrderByTimestampDesc();
        String previousHash = lastLog != null ? lastLog.getHash() : "";
        String hash = computeHash(action, details, previousHash);
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setDetails(details);
        log.setPreviousHash(previousHash);
        log.setHash(hash);
        log.setTimestamp(System.currentTimeMillis());
        return auditLogRepository.save(log);
    }

    private String computeHash(String action, String details, String previousHash) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String data = action + details + previousHash;
            byte[] hashBytes = digest.digest(data.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
