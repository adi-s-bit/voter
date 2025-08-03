package com.example.voter.voter;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String username;
    private String passwordHash;
    private boolean hasVoted;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public boolean isHasVoted() {
        return hasVoted;
    }
    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
