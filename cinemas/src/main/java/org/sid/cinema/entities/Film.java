package org.sid.cinema.entities;

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
public class Film {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String director;
	private String description;
	private String photo;
	private Date daterelease;
	private Double duration;
	
	@OneToMany(mappedBy="film")
	Collection<Position> positions;
	
	@OneToMany(mappedBy="film")
	Collection<Projection> projections;
	
	@ManyToOne
	private Category category;
}
