package org.sid.cinema.dao;

import org.sid.cinema.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long>{

	
}
