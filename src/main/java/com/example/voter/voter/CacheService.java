package com.example.voter.voter;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;

@Service
public class CacheService {
    @Autowired
    private VoteRepository voteRepository;

    @Cacheable(value = "voteCounts", key = "#electionId")
    public List<Object[]> getVoteCounts(UUID electionId) {
        // Implement custom query in VoteRepository for counting votes per candidate
        return voteRepository.countVotesByCandidate(electionId);
    }
}
