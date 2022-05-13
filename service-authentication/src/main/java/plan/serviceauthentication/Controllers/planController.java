package plan.serviceauthentication.Controllers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import plan.serviceauthentication.Models.User;

import java.util.Date;

@RestController
public class planController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${plan.rabbitmq.exchange}")
    private String exchange;
    @Value("${plan.rabbitmq.routingkey}")
    private String routingkey;

    @RequestMapping(value = "/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getProfile() {
        User user = new User("username", "email", new Date());
        return user;
    }

    @GetMapping("/login")
    public ResponseEntity login() {
        User user = new User("pretend this is info", "pretend this is an email", null);
        rabbitTemplate.convertAndSend(exchange, routingkey, user);
        return ResponseEntity.ok().build();
    }

}
