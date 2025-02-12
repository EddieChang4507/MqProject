package com.raymund.api.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka Consumer 類別
 */
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "example-topic", groupId = "example-group")
    public void listen(String message) {
        System.out.println("收到的訊息: " + message);
    }
}

