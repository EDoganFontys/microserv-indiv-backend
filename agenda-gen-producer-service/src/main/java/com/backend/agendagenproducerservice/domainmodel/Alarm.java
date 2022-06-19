package com.backend.agendagenproducerservice.domainmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Entity
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = Alarm.class)
public class Alarm {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long alarmId;
    private Date alarmDatetime;
    private String alarmName;

    public Alarm() {
    }

    public Alarm(Long alarmId, Date alarmDatetime, String alarmName) {
        this.alarmId = alarmId;
        this.alarmDatetime = alarmDatetime;
        this.alarmName = alarmName;
    }

    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
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

    @Override
    public String toString() {
        return "Alarm{" +
                "alarmId=" + alarmId +
                ", alarmDatetime=" + alarmDatetime +
                ", alarmName='" + alarmName + '\'' +
                '}';
    }
}
