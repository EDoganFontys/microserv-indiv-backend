package producer.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import producer.backend.domainmodel.Agenda;

import java.util.Date;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda,Long> {
    @Query(value= "insert into Agenda (agendaCreationDate) values (:agendaCreationDate)", nativeQuery = true)
    void saveAgenda(@Param("agendaCreationDate") Date agendaCreationDate);
}
