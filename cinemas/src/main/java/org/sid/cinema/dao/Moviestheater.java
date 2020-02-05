package org.sid.cinema.dao;

import java.util.Collection;

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
public class Moviestheater {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int numberPlace;
	@ManyToOne
	private Cinema cinema;
	@OneToMany(mappedBy="moviestheater")
	private Collection<Position> positions;
	@OneToMany(mappedBy="moviestheater")
	private Collection<Projection> projections;
	
	 
}
