package com.example.voter.voter;

//import javax.persistence.*;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.UUID;
//dsfkljkasnm
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID voterId;
    private UUID electionId;
    private String candidate;
    private String signature;
    private long timestamp;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getVoterId() {
        return voterId;
    }
    public void setVoterId(UUID voterId) {
        this.voterId = voterId;
    }
    public UUID getElectionId() {
        return electionId;
    }
    public void setElectionId(UUID electionId) {
        this.electionId = electionId;
    }
    public String getCandidate() {
        return candidate;
    }
    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
