package com.backend.agendagenconsumerservice.domainmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Agenda.class)
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date agendaCreationDate;
    private String name;
    @OneToMany(mappedBy = "agenda")
    private List<AgendaItem> agendaItems;

    public Agenda() {
    }

    public Agenda(Date agendaCreationDate, String name) {
        this.agendaCreationDate = agendaCreationDate;
        this.name = name;
    }

    public Agenda(Date agendaCreationDate, String name, List<AgendaItem> agendaItems) {
        this.agendaCreationDate = agendaCreationDate;
        this.name = name;
        this.agendaItems = agendaItems;
    }

    public Agenda(Long id, Date agendaCreationDate, String name, List<AgendaItem> agendaItems) {
        this.id = id;
        this.agendaCreationDate = agendaCreationDate;
        this.name = name;
        this.agendaItems = agendaItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAgendaCreationDate() {
        return agendaCreationDate;
    }

    public void setAgendaCreationDate(Date agendaCreationDate) {
        this.agendaCreationDate = agendaCreationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AgendaItem> getAgendaItems() {
        return agendaItems;
    }

    public void setAgendaItems(List<AgendaItem> agendaItems) {
        this.agendaItems = agendaItems;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", agendaCreationDate=" + agendaCreationDate +
                ", name='" + name + '\'' +
                ", agendaItems=" + agendaItems +
                '}';
    }
}
