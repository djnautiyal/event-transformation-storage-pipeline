package com.example.eventsproducer.controller;

import com.example.eventsproducer.service.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.concurrent.TimeUnit;

//@EnableWebMvc
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private Producer producer;

    //TODO change it with something cooler
    @GetMapping("/kafka/publish")
    public String sendMessageToKafkaTopic(/*@RequestParam("message") String message : Later*/) {
        log.info("running producer");
        for(int i=0; i<10; i++)
            this.producer.sendMessage("Hello, Kafka! Random number: " + Double.valueOf(Math.random()*10000).intValue());
        return "We sent the message. Hopefully, you can read them.";
    }
}
