package com.example.eventsproducer.controller;

import com.example.eventsproducer.service.Consumer;
import com.example.eventsproducer.service.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.concurrent.TimeUnit;

//@EnableWebMvc
@RestController
@RequestMapping("/api/kafka")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    @GetMapping("/publish")
    public String sendMessageToKafkaTopic(/*@RequestParam("message") String message : Later*/) {
        logger.info("running producer???");
        for(int i=0; i<10; i++)
            this.producer.sendMessage("Hello, Kafka! Random number: " + Double.valueOf(Math.random()*10000).intValue());
        return "We sent the message. Hopefully, you can read them.";
    }

    @GetMapping("/read")
    public String readMessageFromKafkaTopic()throws InterruptedException{
        logger.info("running consumer???");
        this.consumer.latch.await(15, TimeUnit.SECONDS);
        return "We read the message. Check the logs.";
    }
}
