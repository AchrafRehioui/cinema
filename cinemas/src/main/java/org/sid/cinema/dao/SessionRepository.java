package org.sid.cinema.dao;

import org.sid.cinema.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface SessionRepository extends JpaRepository<Session, Long>{

	
}
