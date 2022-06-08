package producer.backend;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import producer.backend.domainmodel.Agenda;

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

    public Agenda test(Agenda agenda){
        String sql = "INSERT into agenda VALUES ('2022-04-11T13:08:12.465Z')";
        /*Agenda a = (Agenda) jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Agenda.class));
        System.out.println(a);*/
        return agenda;
    }
    public Agenda saveAgenda(Agenda agenda){
        //agendaRepository.save(agenda);
        send(agenda);
        return agenda;
    }

    public void send(Agenda agenda){
        rabbitTemplate.convertAndSend(exchange,routingkey, agenda);
    }
}
