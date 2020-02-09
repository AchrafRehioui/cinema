package org.sid.cinema.dao;

import org.sid.cinema.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	
}
