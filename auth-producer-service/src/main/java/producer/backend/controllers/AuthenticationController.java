package producer.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import producer.backend.RabbitMqSender;
import producer.backend.domainmodels.LoginUser;
import producer.backend.domainmodels.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    private RabbitMqSender rabbitMqSender;

    @Autowired
    public AuthenticationController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    //todo authentication logic to encrypt user details

    @PostMapping(value = "login")
    public String login(@RequestBody LoginUser user) {
        rabbitMqSender.sendLogin(user);
        return "logged in successfully";
    }

    @PostMapping(value = "register")
    public String register(@RequestBody User user) {
        rabbitMqSender.sendRegister(user);
        return "registered account successfully";
    }

    @GetMapping(value = "user/info")
    public String profileInfo(){
        return "session not implemented  yet";
    }
}
