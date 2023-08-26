package com.example.eventsproducer.controller;

import com.example.eventsproducer.constant.ApiPath;
import com.example.eventsproducer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

//@EnableWebMvc
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private ProducerService producerService;

    //TODO change it with something cooler
    @GetMapping(value= ApiPath.KAFKA_PUBLISH)
    public String sendMessageToKafkaTopic(/*@RequestParam("message") String message : Later*/) {
        log.info("running producerService");
        for(int i=0; i<10; i++)
            this.producerService.sendMessage("Hello, Kafka! Random number: " + Double.valueOf(Math.random()*10000).intValue());
        return "We sent the message. Hopefully, you can read them.";
    }
}
