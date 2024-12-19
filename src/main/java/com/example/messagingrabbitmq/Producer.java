package com.example.messagingrabbitmq;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import org.springframework.amqp.core.MessageProperties;

@Component
public class Producer {

    private final ServiceBusTemplate rabbitTemplate;

    public Producer(ServiceBusTemplate rabbitTemplate) {
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
                rabbitTemplate.send(MessagingRabbitmqApplication.queueName2, responseMessage);
            } else {
                rabbitTemplate.send(MessagingRabbitmqApplication.queueName1, responseMessage);
            }
        }
    }

}
