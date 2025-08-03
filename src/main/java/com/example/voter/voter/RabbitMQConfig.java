package com.example.voter.voter;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue voteQueue() {
        return new Queue("voteQueue", true);
    }
}
