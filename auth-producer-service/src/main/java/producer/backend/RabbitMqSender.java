package producer.backend;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import producer.backend.domainmodels.LoginUser;
import producer.backend.domainmodels.User;

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

    public void sendLogin(LoginUser user){
        rabbitTemplate.convertAndSend(exchange,routingkey, user);
    }
    public void sendRegister(User user){
        rabbitTemplate.convertAndSend(exchange,routingkey, user);
    }
}
