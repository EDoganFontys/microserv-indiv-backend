package com.backend.agendagenproducerservice.controllers;

import com.backend.agendagenproducerservice.RabbitMqSender;
import com.backend.agendagenproducerservice.domainmodel.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/agenda")
public class AgendaGeneratorController {

    private RabbitMqSender rabbitMqSender;

    @Autowired
    public AgendaGeneratorController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @PostMapping(value="create")
    public String createAgenda(@RequestBody Agenda agenda) {
        return rabbitMqSender.saveAgenda(agenda);
}}
