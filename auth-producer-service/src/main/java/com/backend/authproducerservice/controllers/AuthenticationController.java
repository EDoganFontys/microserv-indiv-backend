package com.backend.authproducerservice.controllers;

import com.backend.authproducerservice.RabbitMqSender;
import com.backend.authproducerservice.domainmodels.LoginUser;
import com.backend.authproducerservice.domainmodels.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String register(@RequestBody RegisterUser user) {
        rabbitMqSender.sendRegister(user);
        return "registered account successfully";
    }

    @GetMapping(value = "user/info")
    public String profileInfo(){
        return "session not implemented  yet";
    }
}
