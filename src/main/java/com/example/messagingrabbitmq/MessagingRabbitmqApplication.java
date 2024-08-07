package com.example.messagingrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MessagingRabbitmqApplication {

    static final String queueName1 = "queue1";
    static final String queueName2 = "queue2";

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MessagingRabbitmqApplication.class);
        Producer producer = applicationContext.getBean(Producer.class);
        producer.run();
    }


}
