package org.sid.cinema.dao;

import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long>{

	
}
