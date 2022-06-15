package consumer.backend;

import consumer.backend.domainmodel.Agenda;
import consumer.backend.repository.AgendaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import consumer.backend.domainmodel.AgendaDto;


@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);
    @Autowired
    private AgendaRepo agendaRepo;
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }
    @RabbitListener(queues = "${spring.rabbitmq.queue.post}")
    public void receiveAndSave(Agenda agenda) {
        logger.info("Agenda Details Received is.. " + agenda.toString());
        var repoAgenda = agendaRepo.save(agenda);
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.get}")
    public AgendaDto receiveAndRespond(Long id) {
        logger.info("Received get request for agenda id: " + id);
        var agenda = agendaRepo.findById(id);
        var a = agenda.get();
        AgendaDto tempDto = new AgendaDto(a.getAgendaCreationDate(),a.getName());
        return tempDto;
    }
}
