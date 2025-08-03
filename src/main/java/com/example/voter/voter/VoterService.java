package com.example.voter.voter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VoterService {
    @Autowired
    private VoterRepository voterRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Voter register(String username, String password) {
        Voter voter = new Voter();
        voter.setUsername(username);
        voter.setPasswordHash(passwordEncoder.encode(password));
        voter.setHasVoted(false);
        return voterRepository.save(voter);
    }

    public Voter authenticate(String username, String password) {
        Voter voter = voterRepository.findByUsername(username);
        if (voter != null && passwordEncoder.matches(password, voter.getPasswordHash())) {
            return voter;
        }
        return null;
    }
}
