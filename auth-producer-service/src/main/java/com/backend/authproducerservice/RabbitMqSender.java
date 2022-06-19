package com.backend.authproducerservice;

import com.backend.authproducerservice.domainmodels.CheckResponses;
import com.backend.authproducerservice.domainmodels.RegisterUser;
import com.backend.authproducerservice.payload.response.MessageResponse;
import com.backend.authproducerservice.services.UserService;
import org.hibernate.annotations.Check;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    private RabbitTemplate rabbitTemplate;
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.rabbitTemplate = rabbitTemplate;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public ResponseEntity<MessageResponse> sendRegister(RegisterUser user){
        var checkResponse = userService.checkIfUserExists(user);
        if(checkResponse == CheckResponses.ACCOUNT_AVAILABLE){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            rabbitTemplate.convertAndSend(exchange,routingkey, user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new MessageResponse(CheckResponses.ACCOUNT_AVAILABLE.toString()));
        }
        else if(checkResponse == CheckResponses.EMAIL_EXISTS){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(CheckResponses.EMAIL_EXISTS.toString()));
        }
        else if(checkResponse == CheckResponses.USERNAME_EXISTS){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(CheckResponses.USERNAME_EXISTS.toString()));
        }
        return null;
    }
}
