package com.example.eventsproducer;

import com.example.eventsproducer.service.Consumer;
import com.example.eventsproducer.service.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

//docker compose -f docker-compose-multi-node.yaml up -d

@RestController
@SpringBootApplication()
public class EventsProducerApplication {


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(EventsProducerApplication.class, args);
        Producer producer = context.getBean(Producer.class);
        Consumer consumer = context.getBean(Consumer.class);

        for(int i=0; i<10; i++)
            producer.sendMessage("Hello, Kafka! Times: " + Double.valueOf(Math.random()*10000).intValue());

        consumer.latch.await(15, TimeUnit.SECONDS);

        context.close();
    }
}
