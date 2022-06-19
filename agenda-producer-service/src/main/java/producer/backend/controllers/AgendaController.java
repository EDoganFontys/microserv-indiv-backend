package producer.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import producer.backend.RabbitMqSender;
import producer.backend.domainmodel.Agenda;
import producer.backend.domainmodel.AgendaDto;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

    private RabbitMqSender rabbitMqSender;

    @Autowired
    public AgendaController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @PostMapping(value="create")
    public String createAgenda(@RequestBody Agenda agenda) {
        return rabbitMqSender.saveAgenda(agenda);
    }

    @GetMapping(value = "find")
    public AgendaDto getAgenda(@RequestParam Long agendaId) {
        return /*rabbitMqSender.getAgenda(agendaId);*/null;
    }
}
