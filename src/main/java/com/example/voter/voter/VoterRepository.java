package com.example.voter.voter;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface VoterRepository extends JpaRepository<Voter, UUID> {
    Voter findByUsername(String username);
}
