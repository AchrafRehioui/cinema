package org.sid.cinema.dao;

import org.sid.cinema.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface TicketRepository extends JpaRepository<Ticket, Long>{

	
}
