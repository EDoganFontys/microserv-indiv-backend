package com.backend.agendagenconsumerservice.repository;

import com.backend.agendagenconsumerservice.domainmodel.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepo extends JpaRepository<Agenda, Long> {
}
