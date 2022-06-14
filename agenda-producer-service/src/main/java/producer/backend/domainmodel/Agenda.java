package producer.backend.domainmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Agenda.class)
public class Agenda implements Serializable {
    private Long id;
    private Date agendaCreationDate;
    private String name;
    public Agenda() {
    }

    public Agenda(String name) {
        this.name = name;
    }

    public Agenda(Long id, Date agendaCreationDate) {
        this.id = id;
        this.agendaCreationDate = agendaCreationDate;
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

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", agendaCreationDate=" + agendaCreationDate +
                ", name='" + name + '\'' +
                '}';
    }
}
