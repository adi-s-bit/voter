package com.example.voter.voter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Signature;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;
import java.util.UUID;

@Service
public class VoteService {
    @Autowired
    private VoteQueueProducer voteQueueProducer;
    @Autowired
    private AuditService auditService;

    private KeyPair keyPair;

    public VoteService() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        keyPair = keyGen.generateKeyPair();
    }

    public Vote castVote(UUID voterId, UUID electionId, String candidate) throws Exception {
        String voteData = voterId.toString() + electionId.toString() + candidate + System.currentTimeMillis();
        String signature = signVote(voteData);
        Vote vote = new Vote();
        vote.setVoterId(voterId);
        vote.setElectionId(electionId);
        vote.setCandidate(candidate);
        vote.setSignature(signature);
        vote.setTimestamp(System.currentTimeMillis());
        voteQueueProducer.sendVote(vote);
        auditService.logAction("CAST_VOTE", "Voter: " + voterId + ", Election: " + electionId + ", Candidate: " + candidate);
        return vote;
    }

    private String signVote(String data) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(keyPair.getPrivate());
        privateSignature.update(data.getBytes());
        byte[] signature = privateSignature.sign();
        return Base64.getEncoder().encodeToString(signature);
    }
}
