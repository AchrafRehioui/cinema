package org.sid.cinema.entities;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1", types= {org.sid.cinema.entities.Projection.class})
public interface ProjectionProj {

	public Long getId();
	public double getPrice();
	public Date getDateProjection();
	public Moviestheater getMoviestheater();
	public Film getFilm();
	public Session getSession();
	public Collection<Ticket> getTickets();
	
}
