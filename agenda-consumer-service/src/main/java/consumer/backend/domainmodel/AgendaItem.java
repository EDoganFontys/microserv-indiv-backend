package consumer.backend.domainmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
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
}
