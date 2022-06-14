package consumer.backend.repository;

import consumer.backend.domainmodel.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepo extends JpaRepository<Agenda, Long> {
}
