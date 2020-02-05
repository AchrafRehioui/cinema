package org.sid.cinema.dao;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Projection {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateProjection;
	private double price;
	
	@ManyToOne
	private Moviestheater moviestheater;
	
	@ManyToOne
	private Film film;
	
	@OneToMany(mappedBy="projection")
	private Collection<Ticket> tickets;
	
	@ManyToOne
	private Session session;
	
}
