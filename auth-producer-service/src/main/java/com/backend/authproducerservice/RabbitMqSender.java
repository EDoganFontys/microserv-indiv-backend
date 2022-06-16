package com.backend.authproducerservice;

import com.backend.authproducerservice.domainmodels.LoginUser;
import com.backend.authproducerservice.domainmodels.RegisterUser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    public void sendRegister(RegisterUser user){
        rabbitTemplate.convertAndSend(exchange,routingkey, user);
    }
}
