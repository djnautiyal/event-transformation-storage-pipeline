package com.example.eventsconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Service
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);


    public final CountDownLatch latch = new CountDownLatch(3);


    @KafkaListener(topics = "${message.topic.name}", groupId = "stream")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
