package com.example.voter.voter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteQueueListener {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuditService auditService;

    @RabbitListener(queues = "voteQueue")
    public void receiveVote(Vote vote) {
        voteRepository.save(vote);
        auditService.logAction("QUEUE_VOTE", "Vote received for candidate: " + vote.getCandidate());
    }
}
