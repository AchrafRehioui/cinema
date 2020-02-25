package org.sid.cinema;

import org.sid.cinema.entities.Film;
import org.sid.cinema.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemasApplication implements CommandLineRunner {

	@Autowired
	private ICinemaService cinemaService;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(CinemasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 restConfiguration.exposeIdsFor(Film.class);
		 cinemaService.initCities();
		 cinemaService.initCinemas();
		 cinemaService.initMoviestheater();
		 cinemaService.initPositions();
		 cinemaService.initSessions();
		 cinemaService.initCategories();
		 cinemaService.initFilms();
		 cinemaService.initProjections();
		 cinemaService.initTickets();

	}

}
