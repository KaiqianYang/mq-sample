package com.example.messagingrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MassRolloutRabbitQueueListener {

    /**
     * Kafka Listener to consume all the VIN list from MassRollout Kafka Topic
     *
     * @param message
     */
    @RabbitListener(queues = MessagingRabbitmqApplication.queueName1, group = "${rabbitmq.firemassrollout.group}", containerFactory = "containerFactoryAckAuto",exclusive = true)
    public void listenMassRolloutEvent(String message) {
        System.out.println("Received from Listener <" + message + ">" + "FROM 1");
    }

    @RabbitListener(queues = MessagingRabbitmqApplication.queueName2, group = "${rabbitmq.firemassrollout.group}", containerFactory = "containerFactoryAckAuto",exclusive = true)
    public void listenMassRolloutEvent2(String message) {
        System.out.println("Received from Listener <" + message + ">" + "FROM 2");
    }

}