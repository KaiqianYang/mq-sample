package com.example.messagingrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitQueueListener {

    /**
     * Kafka Listener to consume all the VIN list from MassRollout Kafka Topic
     *
     * @param message
     */
    @RabbitListener(queues = MessagingRabbitmqApplication.queueName1, group = "group1", containerFactory = "containerFactory1",exclusive = true)
    public void listenFrom1(String message) {
        System.out.println("Received from Listener <" + message + ">" + "FROM 1");
    }

    @RabbitListener(queues = MessagingRabbitmqApplication.queueName2, group = "group1", containerFactory = "containerFactory1",exclusive = true)
    public void listenFrom2(String message) {
        System.out.println("Received from Listener <" + message + ">" + "FROM 2");
    }

}
