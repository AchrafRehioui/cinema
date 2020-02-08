package org.sid.cinema.service;

import java.util.stream.Stream;

import org.sid.cinema.dao.CategoryRepository;
import org.sid.cinema.dao.CinemaRepository;
import org.sid.cinema.dao.CityRepository;
import org.sid.cinema.dao.MoviestheaterRepository;
import org.sid.cinema.dao.PositionRepository;
import org.sid.cinema.dao.ProjectionRepository;
import org.sid.cinema.dao.SessionRepository;
import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.City;
import org.sid.cinema.entities.Moviestheater;
import org.sid.cinema.entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl  implements ICinemaService{

	@Autowired  //to add  dependency injection
	private CityRepository cityRepository;
	
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Autowired
	private MoviestheaterRepository moviestheaterRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private ProjectionRepository projectionRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void initCities() {
		Stream.of("Paris","Le havre", "Caen","Rouen").forEach( v->{
			City city= new City();
			city.setName(v);
			cityRepository.save(city);
		});
	}

	@Override
	public void initCinemas() {
		
		cityRepository.findAll().forEach(v->{
			Stream.of("UGC", "kinopolis", "Pathé", "4DX")
			.forEach(nameCinema->{
				Cinema cinema=new Cinema ();
				cinema.setName(nameCinema);
				cinema.setNumberMoviestheater(3+(int)(Math.random()*7));
				cinema.setCity(v);
			});
		});
	}

	@Override
	public void initMoviestheater() {
		cinemaRepository.findAll().forEach(cinema->{
			for(int i=0;i<cinema.getNumberMoviestheater();i++) {
				Moviestheater moviestheater=new Moviestheater();
				moviestheater.setName("moviestheater" + (i+1));
				moviestheater.setCinema(cinema);
				moviestheater.setNumberPlace(20+(int)(Math.random()*10));
				moviestheaterRepository.save(moviestheater);
			}
		});
	}

	@Override
	public void initPositions() {
		moviestheaterRepository.findAll().forEach(moviestheater->{
		    for(int i=0; i<moviestheater.getNumberPlace();i++) {
		    	Position position=new Position();
		    	position.setSeatnumber(i+1);
		    	position.setMoviestheater(moviestheater);
		    	positionRepository.save(position);
		    	
		    }	
		});
	}

	@Override
	public void initSessions() {
		
	}

	@Override
	public void initCategories() {
		
	}

	@Override
	public void initFilms() {
		
	}

	@Override
	public void initProjections() {
		
	}

	@Override
	public void initTickets() {
		
	}

}
