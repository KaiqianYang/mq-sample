package com.example.messagingrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.azure.spring.messaging.servicebus.annotation.ServiceBusListener;
import com.azure.spring.messaging.implementation.annotation.EnableAzureMessaging;

@Component
@Slf4j
@EnableAzureMessaging
public class MassRolloutRabbitQueueListener {

    /**
     * Listener to consume all the VIN list from MassRollout Service Bus Queue
     *
     * @param message
     */
    @ServiceBusListener(queues = MessagingRabbitmqApplication.queueName1, containerFactory = "containerFactoryAckAuto")
    public void listenMassRolloutEvent(String message) {
        System.out.println("Received from Listener <" + message + ">" + "FROM 1");
    }

    @ServiceBusListener(queues = MessagingRabbitmqApplication.queueName2, containerFactory = "containerFactoryAckAuto")
    public void listenMassRolloutEvent2(String message) {
        System.out.println("Received from Listener <" + message + ">" + "FROM 2");
    }

}