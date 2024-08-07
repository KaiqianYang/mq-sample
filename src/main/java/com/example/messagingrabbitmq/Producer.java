package com.example.messagingrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void run()  {
        for (int i = 0; i < 10; i++) {
            System.out.println("Sending message..."+i);
            String responseString = "test "+i;
            MessageProperties properties = new MessageProperties();
            properties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
            Message responseMessage = new Message(responseString.getBytes(), properties);
            if (i % 2 == 0) {
                rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.queueName2, responseMessage);
            } else {
                rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.queueName1, responseMessage);
            }
        }
    }

}
