package org.sid.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.sid.cinema.dao.CategoryRepository;
import org.sid.cinema.dao.CinemaRepository;
import org.sid.cinema.dao.CityRepository;
import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.MoviestheaterRepository;
import org.sid.cinema.dao.PositionRepository;
import org.sid.cinema.dao.ProjectionRepository;
import org.sid.cinema.dao.SessionRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Category;
import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.City;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Moviestheater;
import org.sid.cinema.entities.Position;
import org.sid.cinema.entities.Projection;
import org.sid.cinema.entities.Session;
import org.sid.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional 
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
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	
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
				cinemaRepository.save(cinema);
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
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		
		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
			Session session=new Session();
			try {
				session.setBeginninghour(dateFormat.parse(s));
				sessionRepository.save(session);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Override
	public void initCategories() {
		
			Stream.of("Action","Adventure","Thriller", "Mystry","Horror").forEach(t->{
				Category category = new Category();
				category.setName(t);
				categoryRepository.save(category);
				
			});
			
		
	}

	@Override
	public void initFilms() {
		
		double[] durations= new double[] {1,1.5,2,2.5,3};
		List<Category> categories= categoryRepository.findAll(); 
		Stream.of("book of eli", "intesteler","terminator","underwater","Saw","Ad Astra").forEach(t->{
			Film film= new Film();
			film.setTitle(t);
			film.setDuration(durations[new Random().nextInt(durations.length)]);
			film.setPhoto(t.replaceAll(" ", ""));
			film.setCategory(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);
		});
		
	}

	@Override
	public void initProjections() {
		double[] prices= new double[] {30,50,60,70,90,100};
		cityRepository.findAll().forEach(city->{
			city.getCinemas().forEach(cinema->{
				cinema.getMoviestheaters().forEach(moviesTheater->{
					filmRepository.findAll().forEach(film->{
						sessionRepository.findAll().forEach(session->{
							Projection projection=new Projection();
							projection.setDateProjection(new Date());
							projection.setFilm(film);
							projection.setPrice(prices[new Random().nextInt(prices.length)]);
							projection.setMoviestheater(moviesTheater);
							projection.setSession(session);
							projectionRepository.save(projection);
						});
					});
				});
			});
		});
	}

	@Override
	public void initTickets() {
		
		projectionRepository.findAll().forEach(p->{
			p.getMoviestheater().getPositions().forEach(position->{
				Ticket ticket=new Ticket();
				ticket.setPosition(position);
				ticket.setPrice(p.getPrice());
				ticket.setProjection(p);
				ticket.setBooked(false);
				ticketRepository.save(ticket); 
			});
		});
		
	}

}
