package producer.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import producer.backend.RabbitMqSender;
import producer.backend.domainmodel.Agenda;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

    private RabbitMqSender rabbitMqSender;

    @Autowired
    public AgendaController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @PostMapping()
    public String createAgenda(@RequestBody Agenda agenda) {
        rabbitMqSender.saveAgenda(agenda);
        return "agenda created successfully";
    }

    @GetMapping()
    public String getAgenda(@RequestParam Long agendaId) {
        var agenda = rabbitMqSender.getAgenda(agendaId);
        return "agenda pulled successfully \\n" + agenda;
    }
}
