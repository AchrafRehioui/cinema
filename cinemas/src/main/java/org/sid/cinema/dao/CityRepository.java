package org.sid.cinema.dao;

import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long>{

	
}
