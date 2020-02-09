package org.sid.cinema.dao;

import org.sid.cinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long>{

	
}
