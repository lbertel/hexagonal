package com.ps.infra.eventbus;

import com.ps.domain.port.eventbus.NotificationQueryTrainingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RabbitMQNotificationQueryTrainingEvent implements NotificationQueryTrainingEvent {

    Logger logger = LoggerFactory.getLogger(RabbitMQNotificationQueryTrainingEvent.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQNotificationQueryTrainingEvent(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public void doNotification() {
        String randomUUID = UUID.randomUUID().toString();
        logger.info("Sending UUID: " + randomUUID);
        rabbitTemplate.convertAndSend( "formacion-exchange", "foo.bar.baz", randomUUID);
    }
}
