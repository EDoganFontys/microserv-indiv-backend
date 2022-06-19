package com.backend.agendagenconsumerservice.domainmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Alarm.class)
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date alarmDatetime;
    private String alarmName;
    @OneToOne
    @PrimaryKeyJoinColumn
    private AgendaItem agendaItem;

    public Alarm() {
    }

    public Alarm(Date alarmDatetime, String alarmName) {
        this.alarmDatetime = alarmDatetime;
        this.alarmName = alarmName;
    }

    public Alarm(Long id, Date alarmDatetime, String alarmName, AgendaItem agendaItem) {
        this.id = id;
        this.alarmDatetime = alarmDatetime;
        this.alarmName = alarmName;
        this.agendaItem = agendaItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAlarmDatetime() {
        return alarmDatetime;
    }

    public void setAlarmDatetime(Date alarmDatetime) {
        this.alarmDatetime = alarmDatetime;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public AgendaItem getAgendaItem() {
        return agendaItem;
    }

    public void setAgendaItem(AgendaItem agendaItem) {
        this.agendaItem = agendaItem;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + id +
                ", alarmDatetime=" + alarmDatetime +
                ", alarmName='" + alarmName + '\'' +
                ", agendaItem=" + agendaItem +
                '}';
    }
}
