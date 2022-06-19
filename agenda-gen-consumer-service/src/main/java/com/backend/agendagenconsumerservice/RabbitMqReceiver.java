package com.backend.agendagenconsumerservice;

import com.backend.agendagenconsumerservice.domainmodel.Agenda;
import com.backend.agendagenconsumerservice.repository.AgendaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);
    @Autowired
    private AgendaRepo agendaRepo;
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveAndSave(Agenda agenda) {
        logger.info("Agenda Details Received is.. " + agenda.toString());
        agendaRepo.save(agenda);
    }
}
