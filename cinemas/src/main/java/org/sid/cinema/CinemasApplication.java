package org.sid.cinema;

import org.sid.cinema.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemasApplication implements CommandLineRunner {

	@Autowired
	private ICinemaService cinemaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CinemasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		cinemaService.initCities();
		cinemaService.initCinemas();
		cinemaService.initMoviestheater();
		cinemaService.initPositions();
		cinemaService.initCategories();
		cinemaService.initFilms();
		cinemaService.initProjections();
		cinemaService.initTickets();
		
	}

}
