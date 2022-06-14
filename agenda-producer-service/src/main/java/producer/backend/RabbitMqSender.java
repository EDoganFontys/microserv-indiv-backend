package producer.backend;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import producer.backend.domainmodel.Agenda;
import producer.backend.domainmodel.AgendaDto;

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

    @Value("${spring.rabbitmq.routingkey.post}")
    private String routingkeyPost;
    @Value("${spring.rabbitmq.routingkey.get}")
    private String routingkeyGet;

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

    public AgendaDto getAgenda(Long id){
        return get(id);
    }

    public void send(Agenda agenda){
        rabbitTemplate.convertAndSend(exchange,routingkeyPost, agenda);
    }

    public AgendaDto get(Long id){
        var agenda = rabbitTemplate.convertSendAndReceive(exchange,routingkeyGet, id);
        AgendaDto temp = new AgendaDto();
        return (AgendaDto) agenda;
    }
}
