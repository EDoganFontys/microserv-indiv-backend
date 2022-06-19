package producer.backend;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import producer.backend.domainmodel.Agenda;

import java.util.Date;

@Service
public class RabbitMqSender {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public String saveAgenda(Agenda agenda){
        agenda.setAgendaCreationDate(new Date());
        try {
            send(agenda);
            return "Saved agenda "+ agenda + " successfully!";
        }
        catch(Exception e) {
            return e.toString();
        }
    }

    public void send(Agenda agenda){
        rabbitTemplate.convertAndSend(exchange,routingkey, agenda);
    }

}
