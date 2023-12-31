package com.example.eventsproducer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Slf4j
@Service
public class ProducerService {
    @Value(value = "${message.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
                }
            });
    }

}