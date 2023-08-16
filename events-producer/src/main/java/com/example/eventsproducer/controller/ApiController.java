//package com.example.eventsproducer.controller;
//
//import com.example.eventsproducer.service.Consumer;
//import com.example.eventsproducer.service.Producer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.TimeUnit;
//
//@RestController("/api/kafka")
//public class ApiController {
//
//    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    public ApplicationContext getApplicationContext(){
//        return applicationContext;
//    }
//
//    @GetMapping(value = "/publish")
//    public String sendMessageToKafkaTopic(/*@RequestParam("message") String message : Later*/) {
//        Producer producer = applicationContext.getBean(Producer.class);
//        logger.info("running producer???");
//        for(int i=0; i<10; i++)
//            producer.sendMessage("Hello, Kafka! Random number: " + Double.valueOf(Math.random()*10000).intValue());
//        return "We sent the message. Hopefully, you can read them.";
//    }
//
//    @GetMapping(value="/read")
//    public String readMessageFromKafkaTopic()throws InterruptedException{
//        Consumer consumer = applicationContext.getBean(Consumer.class);
//        logger.info("running consumer???");
//        consumer.latch.await(15, TimeUnit.SECONDS);
//        return "We read the message. Check the logs.";
//    }
//}
