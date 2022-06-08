package consumer.backend.domainmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Agenda.class)
public class Agenda implements Serializable {

    private Long agendaId;
    private Date agendaCreationDate;

    public Agenda() {
    }

    public Agenda(Long agendaId, Date agendaCreationDate) {
        this.agendaId = agendaId;
        this.agendaCreationDate = agendaCreationDate;
    }

    public Long getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(Long agendaId) {
        this.agendaId = agendaId;
    }

    public Date getAgendaCreationDate() {
        return agendaCreationDate;
    }

    public void setAgendaCreationDate(Date agendaCreationDate) {
        this.agendaCreationDate = agendaCreationDate;
    }


    @Override
    public String toString() {
        return "Agenda{" +
                "agendaId=" + agendaId +
                ", agendaCreationDate=" + agendaCreationDate +
                '}';
    }
}
