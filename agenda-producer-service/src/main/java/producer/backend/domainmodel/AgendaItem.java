package producer.backend.domainmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

//import javax.persistence.*;

//@Entity
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = AgendaItem.class)
public class AgendaItem {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long agendaItemId;
    private String agendaItemName;
    private String agendaItemEvent;

    public AgendaItem() {

    }

    public AgendaItem(String agendaItemName, String agendaItemEvent) {
        this.agendaItemName = agendaItemName;
        this.agendaItemEvent = agendaItemEvent;
    }

    public Long getAgendaItemId() {
        return agendaItemId;
    }

    public void setAgendaItemId(Long agendaItemId) {
        this.agendaItemId = agendaItemId;
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

    @Override
    public String toString() {
        return "AgendaItem{" +
                "agendaItemId=" + agendaItemId +
                ", agendaItemName='" + agendaItemName + '\'' +
                ", agendaItemEvent='" + agendaItemEvent + '\'' +
                '}';
    }
}
