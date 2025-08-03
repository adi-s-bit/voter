package com.example.voter.voter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/vote")
public class VoterController {
    @Autowired
    private VoterService voterService;
    @Autowired
    private VoteService voteService;

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        voterService.register(username, password);
        return "Registered";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Voter voter = voterService.authenticate(username, password);
        return voter != null ? "Login successful" : "Login failed";
    }

    @PostMapping("/cast")
    public String castVote(@RequestParam UUID voterId, @RequestParam UUID electionId, @RequestParam String candidate) {
        try {
            voteService.castVote(voterId, electionId, candidate);
            return "Vote cast successfully";
        } catch (Exception e) {
            return "Vote failed: " + e.getMessage();
        }
    }
}
