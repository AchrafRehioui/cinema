package org.sid.cinema.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	@JsonProperty(access=Access.WRITE_ONLY)
	private Cinema cinema;
	
	@OneToMany(mappedBy="moviestheater")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Position> positions;
	
	@OneToMany(mappedBy="moviestheater")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Projection> projections;
	
	 
}
