package com.example.messagingrabbitmq;

import com.azure.spring.messaging.implementation.annotation.EnableAzureMessaging;
import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@EnableAzureMessaging
@Component
@Slf4j
public class MassRolloutRabbitQueueListener {

    /**
     * Kafka Listener to consume all the VIN list from MassRollout Kafka Topic
     *
     * @param message
     */
    @ServiceBusListener(destination = MessagingRabbitmqApplication.queueName1)
    public void listenMassRolloutEvent(String message) {
        System.out.println("Received from Listener <" + message + ">" + "FROM 1");
    }

    @ServiceBusListener(destination = MessagingRabbitmqApplication.queueName2)
    public void listenMassRolloutEvent2(String message) {
        System.out.println("Received from Listener <" + message + ">" + "FROM 2");
    }

}