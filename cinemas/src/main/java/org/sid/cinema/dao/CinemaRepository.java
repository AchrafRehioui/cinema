package org.sid.cinema.dao;

import org.sid.cinema.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface CinemaRepository extends JpaRepository<Cinema, Long>{

	
}
