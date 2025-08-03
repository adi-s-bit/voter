package com.example.voter.voter;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ElectionRepository extends JpaRepository<Election, UUID> {
}
