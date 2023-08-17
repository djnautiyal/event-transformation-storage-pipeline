package com.example.eventsproducer;

import com.example.eventsproducer.service.Consumer;
import com.example.eventsproducer.service.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class EventsProducerApplication {


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(EventsProducerApplication.class, args);
    }
}
