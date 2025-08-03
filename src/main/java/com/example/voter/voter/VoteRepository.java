package com.example.voter.voter;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, UUID> {
    @Query("SELECT v.candidate, COUNT(v) FROM Vote v WHERE v.electionId = :electionId GROUP BY v.candidate")
    List<Object[]> countVotesByCandidate(@Param("electionId") UUID electionId);
}
