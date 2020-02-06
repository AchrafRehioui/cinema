package org.sid.cinema.service;

import java.util.stream.Stream;

import org.sid.cinema.dao.CinemaRepository;
import org.sid.cinema.dao.CityRepository;
import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl  implements ICinemaService{

	@Autowired  //to add  dependency injection
	private CityRepository cityRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Override
	public void initCities() {
		// TODO Auto-generated method stub
		Stream.of("Paris","Le havre", "Caen","Rouen").forEach( v->{
			City city= new City();
			city.setName(v);
			cityRepository.save(city);
		});
	}

	@Override
	public void initCinemas() {
		// TODO Auto-generated method stub
		cityRepository.findAll().forEach(v->{
			Stream.of("UGC", "kinopolis", "Pathé", "4DX")
			.forEach(nameCinema->{
				Cinema cinema=new Cinema ();
				cinema.setName(nameCinema);
				cinema.setCity(v);
			});
		});
	}

	@Override
	public void initMoviestheater() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initPositions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initSessions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initCategories() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initFilms() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initProjections() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initTickets() {
		// TODO Auto-generated method stub
		
	}

}
