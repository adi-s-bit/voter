package com.example.voter.voter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/results")
public class ResultsController {
    @Autowired
    private VoteRepository voteRepository;

    @GetMapping("/count/{electionId}")
    public List<Object[]> getVoteCount(@PathVariable String electionId) {
        // This should be cached in production
        return voteRepository.countVotesByCandidate(UUID.fromString(electionId));
    }
}
