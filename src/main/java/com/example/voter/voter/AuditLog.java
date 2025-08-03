package com.example.voter.voter;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String action;
    private String details;
    private String hash;
    private String previousHash;
    private long timestamp;
    // ...getters and setters...
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getPreviousHash() {
        return previousHash;
    }
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
