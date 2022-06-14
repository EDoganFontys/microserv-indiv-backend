package consumer.backend.domainmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = AgendaItem.class)
public class AgendaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agendaItemName;
    private String agendaItemEvent;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Agenda agenda;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Alarm alarm;

    public AgendaItem() {
    }

    public AgendaItem(String agendaItemName, String agendaItemEvent, Agenda agenda) {
        this.agendaItemName = agendaItemName;
        this.agendaItemEvent = agendaItemEvent;
        this.agenda = agenda;
    }

    public AgendaItem(String agendaItemName, String agendaItemEvent, Agenda agenda, Alarm alarm) {
        this.agendaItemName = agendaItemName;
        this.agendaItemEvent = agendaItemEvent;
        this.agenda = agenda;
        this.alarm = alarm;
    }

    public AgendaItem(Long id, String agendaItemName, String agendaItemEvent, Agenda agenda, Alarm alarm) {
        this.id = id;
        this.agendaItemName = agendaItemName;
        this.agendaItemEvent = agendaItemEvent;
        this.agenda = agenda;
        this.alarm = alarm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgendaItemName() {
        return agendaItemName;
    }

    public void setAgendaItemName(String agendaItemName) {
        this.agendaItemName = agendaItemName;
    }

    public String getAgendaItemEvent() {
        return agendaItemEvent;
    }

    public void setAgendaItemEvent(String agendaItemEvent) {
        this.agendaItemEvent = agendaItemEvent;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public String toString() {
        return "AgendaItem{" +
                "id=" + id +
                ", agendaItemName='" + agendaItemName + '\'' +
                ", agendaItemEvent='" + agendaItemEvent + '\'' +
                ", agenda=" + agenda +
                ", alarm=" + alarm +
                '}';
    }
}
