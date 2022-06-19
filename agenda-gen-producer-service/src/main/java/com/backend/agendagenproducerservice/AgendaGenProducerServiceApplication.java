package com.backend.agendagenproducerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EntityScan
public class AgendaGenProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendaGenProducerServiceApplication.class, args);
    }

}
