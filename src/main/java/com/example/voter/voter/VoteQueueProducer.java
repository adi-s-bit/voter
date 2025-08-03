package com.example.voter.voter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteQueueProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendVote(Vote vote) {
        rabbitTemplate.convertAndSend("voteQueue", vote);
    }
}
